import json
from pathlib import Path

from rapidfuzz import process

from app.utils.logger import logger
from app.utils.text_utils import normalize_text


class AIService:

    def __init__(self):

        dataset_path = (
            Path(__file__).resolve().parents[3]
            / "datasets"
            / "processed"
            / "biology.json"
        )

        try:
            with open(dataset_path, "r", encoding="utf-8") as file:
                self.knowledge_base = json.load(file)

        except FileNotFoundError:

            logger.error(f"Dataset not found: {dataset_path}")

            self.knowledge_base = []

        except Exception as e:

            logger.error(f"Error loading dataset: {e}")

            self.knowledge_base = []

    def generate_answer(self, question: str) -> str:

        question = normalize_text(question)

        topics = [item["topic"] for item in self.knowledge_base]

        result = process.extractOne(question, topics)

        if result is not None:

            matched_topic = result[0]
            score = result[1]

            if score >= 70:

                for item in self.knowledge_base:

                    if item["topic"] == matched_topic:
                        return item["answer"]

        return (
            "Sorry, I don't know the answer yet. "
            "This topic is not available in the current knowledge base."
        )