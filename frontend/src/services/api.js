const API_BASE_URL = "http://localhost:8080";

async function request(endpoint, options = {}) {
  const token = localStorage.getItem("arogya_token");

  const headers = {
    "Content-Type": "application/json",
    ...(options.headers || {}),
  };

  if (token) {
    headers.Authorization = `Bearer ${token}`;
  }

  const response = await fetch(`${API_BASE_URL}${endpoint}`, {
    ...options,
    headers,
  });

  const contentType = response.headers.get("content-type");

  let data;

  if (contentType && contentType.includes("application/json")) {
    data = await response.json();
  } else {
    data = await response.text();
  }

  if (!response.ok) {
    const message =
      typeof data === "string"
        ? data
        : data?.message || "Something went wrong";

    throw new Error(message);
  }

  return data;
}

export const authAPI = {
  signup: (name, email, password) =>
    request("/api/auth/signup", {
      method: "POST",
      body: JSON.stringify({
        name,
        email,
        password,
      }),
    }),

  login: (email, password) =>
    request("/api/auth/login", {
      method: "POST",
      body: JSON.stringify({
        email,
        password,
      }),
    }),

  getCurrentUser: () =>
    request("/api/users/me", {
      method: "GET",
    }),
};

export default request;