from app.embeddings.embedding_service import EmbeddingService
from app.embeddings.vector_store import VectorStore

embedding_service = EmbeddingService()
vector_store = VectorStore()

query = "Which organ pumps blood?"

query_embedding = embedding_service.generate_embedding(query)

results = vector_store.search(query_embedding)


print("\nQuery:")
print(query)

print("\nResults:")
print("\nFull Results:")
print(results)
print(results["metadatas"][0][0]["topic"])
print(results["documents"][0][0])