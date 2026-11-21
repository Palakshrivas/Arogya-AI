import { createContext, useContext, useEffect, useState } from "react";
import { authAPI } from "../services/api";

const AuthContext = createContext(null);

export function AuthProvider({ children }) {
  const [user, setUser] = useState(() => {
    const savedUser = localStorage.getItem("arogya_user");
    return savedUser ? JSON.parse(savedUser) : null;
  });

  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const token = localStorage.getItem("arogya_token");

    if (!token) {
      setLoading(false);
      return;
    }

    authAPI
      .getCurrentUser()
      .then((currentUser) => {
        setUser(currentUser);

        localStorage.setItem(
          "arogya_user",
          JSON.stringify(currentUser)
        );
      })
      .catch(() => {
        localStorage.removeItem("arogya_token");
        localStorage.removeItem("arogya_user");
        setUser(null);
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  const signup = async (name, email, password) => {
    try {
      const response = await authAPI.signup(
        name.trim(),
        email.trim().toLowerCase(),
        password
      );

      if (!response?.token) {
        return {
          success: false,
          message: "Signup failed. Token not received.",
        };
      }

      const loggedInUser = {
        id: response.id,
        name: response.name,
        email: response.email,
        role: response.role,
      };

      localStorage.setItem(
        "arogya_token",
        response.token
      );

      localStorage.setItem(
        "arogya_user",
        JSON.stringify(loggedInUser)
      );

      setUser(loggedInUser);

      return {
        success: true,
        user: loggedInUser,
      };
    } catch (error) {
      return {
        success: false,
        message: error.message || "Signup failed.",
      };
    }
  };

  const login = async (email, password) => {
    try {
      const response = await authAPI.login(
        email.trim().toLowerCase(),
        password
      );

      if (!response?.token) {
        return {
          success: false,
          message: "Login failed. Token not received.",
        };
      }

      // Save JWT immediately
      localStorage.setItem(
        "arogya_token",
        response.token
      );

      /*
       * Login API already returns:
       * token, id, name, email, role
       *
       * So we do NOT need another API call here.
       */

      const loggedInUser = {
        id: response.id,
        name: response.name,
        email: response.email,
        role: response.role,
      };

      localStorage.setItem(
        "arogya_user",
        JSON.stringify(loggedInUser)
      );

      setUser(loggedInUser);

      return {
        success: true,
        user: loggedInUser,
      };
    } catch (error) {
      return {
        success: false,
        message: error.message || "Login failed.",
      };
    }
  };

  const logout = () => {
    localStorage.removeItem("arogya_token");
    localStorage.removeItem("arogya_user");
    setUser(null);
  };

  return (
    <AuthContext.Provider
      value={{
        user,
        loading,
        isAuthenticated: !!user,
        signup,
        login,
        logout,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  return useContext(AuthContext);
}