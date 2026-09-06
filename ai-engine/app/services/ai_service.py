from app.embeddings.embedding_service import EmbeddingService
from app.embeddings.vector_store import VectorStore
from app.utils.logger import logger


class AIService:
    """
    Handles semantic search using Sentence Transformers and ChromaDB.
    """

    def __init__(self):
        self.embedding_service = EmbeddingService()
        self.vector_store = VectorStore()

    def generate_answer(self, question: str) -> str:

        try:
            logger.info(f"Generating embedding for: {question}")

            # Generate embedding
            embedding = self.embedding_service.generate_embedding(question)

            # Search top 3 similar documents
            results = self.vector_store.search(
                embedding,
                n_results=3
            )

            # No result found
            if (
                not results["documents"]
                or not results["documents"][0]
            ):
                logger.warning("No matching documents found.")

                return (
                    "Sorry, I couldn't find any relevant information."
                )

            # Best match distance
            best_distance = results["distances"][0][0]

            logger.info(f"Best Match Distance: {best_distance}")

            # Similarity threshold
            if best_distance > 1.2:

                logger.warning(
                    "Match confidence too low."
                )

                return (
                    "Sorry, I couldn't find a reliable answer "
                    "in the knowledge base."
                )

            answer = results["documents"][0][0]

            logger.info("Semantic search successful.")

            return answer

        except Exception as e:

            logger.error(f"Semantic Search Error: {e}")

            return (
                "Sorry, something went wrong while "
                "searching the knowledge base."
            )