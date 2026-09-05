import { Link } from "react-router-dom";
import { ArrowLeft, ArrowRight, Brain, Mail } from "lucide-react";

function ForgetPassword() {
  const handleSubmit = (e) => {
    e.preventDefault();
    alert("Password reset link will be sent to your email.");
  };

  return (
    <div className="min-h-screen bg-slate-50 flex items-center justify-center px-4">
      <div className="w-full max-w-md">

        <div className="text-center mb-8">
          <div className="mx-auto w-14 h-14 rounded-2xl bg-indigo-600 text-white flex items-center justify-center shadow-lg">
            <Brain size={30} />
          </div>

          <h1 className="mt-5 text-3xl font-bold text-slate-900">
            Forgot your password?
          </h1>

          <p className="mt-2 text-slate-500">
            Enter your email and we'll help you get back into your account.
          </p>
        </div>

        <div className="bg-white border border-slate-200 rounded-3xl p-8 shadow-xl">

          <form onSubmit={handleSubmit} className="space-y-5">

            <div>
              <label className="block text-sm font-semibold text-slate-700 mb-2">
                Email Address
              </label>

              <div className="relative">
                <Mail
                  size={19}
                  className="absolute left-4 top-1/2 -translate-y-1/2 text-slate-400"
                />

                <input
                  type="email"
                  placeholder="you@example.com"
                  required
                  className="w-full pl-11 pr-4 py-3.5 border border-slate-200 rounded-xl outline-none focus:ring-2 focus:ring-indigo-500"
                />
              </div>
            </div>

            <button
              type="submit"
              className="w-full bg-indigo-600 hover:bg-indigo-700 text-white font-semibold py-3.5 rounded-xl flex items-center justify-center gap-2 transition"
            >
              Send Reset Link
              <ArrowRight size={19} />
            </button>

          </form>

          <Link
            to="/login"
            className="mt-6 flex items-center justify-center gap-2 text-sm font-semibold text-indigo-600 hover:text-indigo-700"
          >
            <ArrowLeft size={17} />
            Back to Sign In
          </Link>

        </div>

        <p className="text-center text-xs text-slate-400 mt-6">
          Arogya-AI • Learn • Solve • Master
        </p>

      </div>
    </div>
  );
}

export default ForgetPassword;