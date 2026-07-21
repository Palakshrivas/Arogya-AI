from fastapi import FastAPI

from app.api.routes import router
from app.config.settings import settings

app = FastAPI(
    title=settings.app_name,
    version=settings.app_version,
)

app.include_router(router)


@app.get("/")
def root():
    return {
        "message": f"Welcome to {settings.app_name}",
        "version": settings.app_version,
    }