from app.services.chat_service import ChatService
from fastapi import APIRouter
from app.models.chat_models import ChatRequest, ChatResponse

router = APIRouter()


@router.get("/")
def home():
    return {
        "project": "ArogyaAI",
        "status": "Running",
        "version": "1.0.0"
    }

@router.get("/health")
def health():
    return {
        "status": "healthy",
        "server": "running",
        "message": "ArogyaAI Backend is working properly."
        }
@router.post("/chat", response_model=ChatResponse)
def chat(request: ChatRequest):

    service = ChatService()

    return service.generate_response(request.question)