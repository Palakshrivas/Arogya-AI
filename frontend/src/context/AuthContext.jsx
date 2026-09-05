import { createContext, useContext, useState } from "react";

const AuthContext = createContext(null);

export function AuthProvider({ children }) {
  const [user, setUser] = useState(() => {
    const savedUser = localStorage.getItem("arogya_user");
    return savedUser ? JSON.parse(savedUser) : null;
  });

  const signup = (name, email, password) => {
    const existingUser = localStorage.getItem("arogya_account");

    if (existingUser) {
      return {
        success: false,
        message: "Account already exists. Please sign in.",
      };
    }

    const account = {
      name,
      email,
      password,
    };

    localStorage.setItem("arogya_account", JSON.stringify(account));

    setUser({
      name,
      email,
    });

    localStorage.setItem(
      "arogya_user",
      JSON.stringify({
        name,
        email,
      })
    );

    return {
      success: true,
    };
  };

  const login = (email, password) => {
    const savedAccount = localStorage.getItem("arogya_account");

    if (!savedAccount) {
      return {
        success: false,
        message: "No account found. Please create an account first.",
      };
    }

    const account = JSON.parse(savedAccount);

    if (account.email !== email || account.password !== password) {
      return {
        success: false,
        message: "Invalid email or password.",
      };
    }

    const loggedInUser = {
      name: account.name,
      email: account.email,
    };

    setUser(loggedInUser);

    localStorage.setItem(
      "arogya_user",
      JSON.stringify(loggedInUser)
    );

    return {
      success: true,
    };
  };

  const logout = () => {
    setUser(null);
    localStorage.removeItem("arogya_user");
  };

  return (
    <AuthContext.Provider
      value={{
        user,
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