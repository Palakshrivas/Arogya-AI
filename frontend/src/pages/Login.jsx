import { Link } from "react-router-dom";
import { Brain, Mail, Lock, ArrowRight, Eye, EyeOff } from "lucide-react";
import { useState } from "react";

function Login() {
  const [showPassword, setShowPassword] = useState(false);

  return (
    <div className="min-h-screen bg-slate-50 flex items-center justify-center px-4 py-10">
      <div className="w-full max-w-md">

        {/* Logo */}
        <div className="text-center mb-8">
          <Link to="/" className="inline-flex items-center gap-3">
            <div className="w-12 h-12 rounded-xl bg-indigo-600 flex items-center justify-center shadow-lg shadow-indigo-200">
              <Brain size={27} className="text-white" />
            </div>

            <div className="text-left">
              <h1 className="text-2xl font-extrabold text-slate-950">
                Arogya<span className="text-indigo-600">-AI</span>
              </h1>
              <p className="text-[10px] font-bold tracking-[0.18em] text-slate-400">
                LEARN • SOLVE • MASTER
              </p>
            </div>
          </Link>
        </div>

        {/* Card */}
        <div className="bg-white border border-slate-200 rounded-3xl p-8 shadow-xl shadow-slate-200/50">

          <div className="mb-7">
            <h2 className="text-3xl font-extrabold text-slate-950">
              Welcome back
            </h2>

            <p className="mt-2 text-slate-500">
              Sign in to continue your JEE & NEET preparation.
            </p>
          </div>

          {/* Google */}
          <button className="w-full h-12 border border-slate-200 rounded-xl flex items-center justify-center gap-3 font-semibold text-slate-700 hover:bg-slate-50 transition">
            <span className="text-lg font-bold">G</span>
            Continue with Google
          </button>

          <div className="flex items-center gap-4 my-6">
            <div className="h-px bg-slate-200 flex-1"></div>
            <span className="text-xs font-medium text-slate-400">
              OR CONTINUE WITH EMAIL
            </span>
            <div className="h-px bg-slate-200 flex-1"></div>
          </div>

          {/* Email */}
          <div className="mb-5">
            <label className="block text-sm font-semibold text-slate-700 mb-2">
              Email address
            </label>

            <div className="relative">
              <Mail
                size={19}
                className="absolute left-4 top-1/2 -translate-y-1/2 text-slate-400"
              />

              <input
                type="email"
                placeholder="you@example.com"
                className="w-full h-12 pl-11 pr-4 rounded-xl border border-slate-200 outline-none text-slate-800 placeholder:text-slate-400 focus:border-indigo-500 focus:ring-4 focus:ring-indigo-100 transition"
              />
            </div>
          </div>

          {/* Password */}
          <div className="mb-3">
            <div className="flex justify-between items-center mb-2">
              <label className="text-sm font-semibold text-slate-700">
                Password
              </label>

              <Link
                to="/forgot-password"
                className="text-sm font-semibold text-indigo-600 hover:text-indigo-700"
              >
                Forgot password?
              </Link>
            </div>

            <div className="relative">
              <Lock
                size={19}
                className="absolute left-4 top-1/2 -translate-y-1/2 text-slate-400"
              />

              <input
                type={showPassword ? "text" : "password"}
                placeholder="Enter your password"
                className="w-full h-12 pl-11 pr-12 rounded-xl border border-slate-200 outline-none text-slate-800 placeholder:text-slate-400 focus:border-indigo-500 focus:ring-4 focus:ring-indigo-100 transition"
              />

              <button
                type="button"
                onClick={() => setShowPassword(!showPassword)}
                className="absolute right-4 top-1/2 -translate-y-1/2 text-slate-400 hover:text-slate-600"
              >
                {showPassword ? <EyeOff size={19} /> : <Eye size={19} />}
              </button>
            </div>
          </div>

          {/* Remember */}
          <label className="flex items-center gap-2 my-5 text-sm text-slate-500 cursor-pointer">
            <input
              type="checkbox"
              className="w-4 h-4 accent-indigo-600"
            />
            Remember me
          </label>

          {/* Sign In */}
          <button
            type="button"
            className="group w-full h-12 rounded-xl bg-indigo-600 text-white font-bold flex items-center justify-center gap-2 shadow-lg shadow-indigo-200 hover:bg-indigo-700 hover:-translate-y-0.5 transition"
          >
            Sign In
            <ArrowRight
              size={18}
              className="group-hover:translate-x-1 transition"
            />
          </button>

          {/* Signup */}
          <p className="text-center text-sm text-slate-500 mt-7">
            Don't have an account?{" "}
            <Link
              to="/signup"
              className="font-bold text-indigo-600 hover:text-indigo-700"
            >
              Create an account
            </Link>
          </p>
        </div>

        <p className="text-center text-xs text-slate-400 mt-6">
          © 2026 Arogya-AI • Built for JEE & NEET aspirants
        </p>
      </div>
    </div>
  );
}

export default Login;