from google import genai

from app.config.settings import settings
from app.utils.logger import logger


class GeminiService:
    """
    Handles communication with the Gemini API.
    """

    def __init__(self):
        self.client = genai.Client(
            api_key=settings.gemini_api_key
        )

    def generate_answer(self, context: str, question: str) -> str:
        """
        Generate an answer using the retrieved context.
        """

        try:

            prompt = f"""
You are ArogyaAI, a medical assistant.

Answer ONLY using the provided context.

If the answer is not present in the context,
reply:
"I couldn't find that information in my knowledge base."

Context:
{context}

Question:
{question}

Answer:
"""

            response = self.client.models.generate_content(
                model="gemini-2.5-flash",
                contents=prompt,
            )

            return response.text

        except Exception as e:

            logger.error(f"Gemini Error: {e}")

            return (
                "Sorry, Gemini could not generate an answer."
            )