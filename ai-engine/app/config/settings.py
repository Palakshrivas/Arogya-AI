from pathlib import Path

# Project Root
BASE_DIR = Path(__file__).resolve().parents[3]

# Dataset Paths
DATASET_DIR = BASE_DIR / "datasets" / "processed"

BIOLOGY_DATASET = DATASET_DIR / "biology.json"