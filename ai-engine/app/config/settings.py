from pathlib import Path

from pydantic_settings import BaseSettings, SettingsConfigDict

BASE_DIR = Path(__file__).resolve().parents[3]

DATASET_DIR = BASE_DIR / "datasets" / "processed"

BIOLOGY_DATASET = DATASET_DIR / "biology.json"


class Settings(BaseSettings):
    app_name: str
    app_version: str
    debug: bool

    model_config = SettingsConfigDict(
        env_file=BASE_DIR / ".env",
        env_file_encoding="utf-8",
    )


settings = Settings()