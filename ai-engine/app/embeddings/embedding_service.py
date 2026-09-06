from sentence_transformers import SentenceTransformer


class EmbeddingService:
    """
    Loads and manages the sentence transformer model.
    """

    def __init__(self):
        self.model = SentenceTransformer("all-MiniLM-L6-v2")

    def generate_embedding(self, text: str):
        """
        Generate an embedding vector for the given text.
        """
        return self.model.encode(text).tolist()