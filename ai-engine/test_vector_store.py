from app.embeddings.vector_store import VectorStore

print("Initializing ChromaDB...")

vector_store = VectorStore()

print("ChromaDB initialized successfully!")
print("Collection Name:", vector_store.collection.name)