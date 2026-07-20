import re


def normalize_text(text: str) -> str:
    """
    Normalize user input.
    """

    text = text.lower()

    text = re.sub(r"[^a-z0-9\s]", "", text)

    text = text.strip()

    return text