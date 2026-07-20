from fastapi import HTTPException
from app.models.chat_models import ChatResponse
from app.services.ai_service import AIService
from app.utils.logger import logger


class ChatService:

    def __init__(self):
        self.ai = AIService()

    def generate_response(self, question: str):

        try:

            logger.info(f"User Question: {question}")

            answer = self.ai.generate_answer(question)

            logger.info(f"AI Answer: {answer}")

            return ChatResponse(answer=answer)

        except Exception as e:

            logger.error(f"Error: {str(e)}")

            raise HTTPException(
                status_code=500,
                detail="Internal Server Error"
            )