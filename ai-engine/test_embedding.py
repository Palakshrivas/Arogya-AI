from app.embeddings.embedding_service import EmbeddingService

print("Loading embedding model...")

embedding_service = EmbeddingService()

print("Model loaded successfully!")

text = "The heart pumps blood throughout the body."

embedding = embedding_service.generate_embedding(text)

print(f"Embedding length: {len(embedding)}")
print(f"First 10 values: {embedding[:10]}")