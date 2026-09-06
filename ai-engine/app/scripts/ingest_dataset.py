import json

from app.config.settings import BIOLOGY_DATASET
from app.embeddings.embedding_service import EmbeddingService
from app.embeddings.vector_store import VectorStore


def ingest():
    embedding_service = EmbeddingService()
    vector_store = VectorStore()

    with open(BIOLOGY_DATASET, "r", encoding="utf-8") as file:
        data = json.load(file)

    for index, item in enumerate(data):
        topic = item["topic"]
        answer = item["answer"]

        text = f"{topic}. {answer}"

        embedding = embedding_service.generate_embedding(text)

        vector_store.collection.add(
            ids=[str(index)],
            embeddings=[embedding],
            documents=[answer],
            metadatas=[{"topic": topic}],
        )

    print(f"Successfully inserted {len(data)} records into ChromaDB.")


if __name__ == "__main__":
    ingest()