from pathlib import Path

import chromadb


class VectorStore:
    """
    Initializes and manages the persistent ChromaDB collection.
    """

    def __init__(self):
        db_path = Path("chroma_db")

        self.client = chromadb.PersistentClient(path=str(db_path))

        self.collection = self.client.get_or_create_collection(
            name="biology_knowledge"
        )

    def search(self, query_embedding, n_results=3):
        """
        Search the vector database and return the top matching documents.
        """
        return self.collection.query(
            query_embeddings=[query_embedding],
            n_results=n_results,
            include=["documents", "metadatas", "distances"],
        )