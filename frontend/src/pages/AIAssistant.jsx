import { useState } from "react";
import { useSearchParams, Link } from "react-router-dom";
import {
  Upload,
  Image as ImageIcon,
  Send,
  X,
  ArrowLeft,
  Sparkles,
  MessageSquare,
  BookOpen,
} from "lucide-react";

function AIAssistant() {
  const [searchParams] = useSearchParams();

  const uploadMode = searchParams.get("upload") === "true";

  const [image, setImage] = useState(null);
  const [question, setQuestion] = useState("");
  const [subject, setSubject] = useState("Physics");
  const [solving, setSolving] = useState(false);
  const [solution, setSolution] = useState(null);

  const handleImageUpload = (e) => {
    const file = e.target.files?.[0];

    if (!file) return;

    const imageUrl = URL.createObjectURL(file);
    setImage(imageUrl);
  };

  const removeImage = () => {
    if (image) {
      URL.revokeObjectURL(image);
    }

    setImage(null);
  };

  const handleSolve = () => {
    if (!question.trim() && !image) {
      alert("Please enter a question or upload an image.");
      return;
    }

    setSolving(true);

    setTimeout(() => {
      setSolving(false);

      setSolution({
        subject,
        steps: [
          "Identify the given information from the question.",
          "Choose the appropriate concept or formula.",
          "Substitute the given values carefully.",
          "Simplify the calculation step by step.",
          "Verify the final answer.",
        ],
      });
    }, 1000);
  };

  return (
    <div className="min-h-screen bg-slate-50">
      {/* HEADER */}
      <header className="sticky top-0 z-30 border-b border-slate-200 bg-white">
        <div className="flex h-20 items-center justify-between px-6 lg:px-10">
          <div className="flex items-center gap-3">
            <div className="flex h-11 w-11 items-center justify-center rounded-xl bg-indigo-600 text-white shadow-lg shadow-indigo-200">
              <Sparkles size={23} />
            </div>

            <div>
              <h1 className="text-lg font-bold text-slate-900">
                Arogya-AI Solver
              </h1>

              <p className="text-xs text-slate-400">
                Your personal JEE & NEET problem-solving assistant
              </p>
            </div>
          </div>

          <div className="hidden items-center gap-2 rounded-full bg-emerald-50 px-4 py-2 text-sm font-semibold text-emerald-600 sm:flex">
            <span className="h-2 w-2 rounded-full bg-emerald-500" />
            AI Online
          </div>
        </div>
      </header>

      {/* MAIN */}
      <main className="mx-auto max-w-6xl px-5 py-10">
        {/* ================= UPLOAD MODE ================= */}
        {uploadMode ? (
          <div>
            {/* BACK */}
            <Link
              to="/"
              className="mb-8 inline-flex items-center gap-2 text-sm font-semibold text-slate-600 transition hover:text-indigo-600"
            >
              <ArrowLeft size={17} />
              Back to Home
            </Link>

            {/* TITLE */}
            <div className="mb-8 text-center">
              <div className="mx-auto flex h-16 w-16 items-center justify-center rounded-2xl bg-indigo-100 text-indigo-600">
                <Upload size={29} />
              </div>

              <h2 className="mt-5 text-3xl font-bold text-slate-900">
                Upload Your Question
              </h2>

              <p className="mx-auto mt-3 max-w-2xl text-slate-500">
                Upload a photo or screenshot of your JEE or NEET question.
                Arogya-AI will help you understand it step by step.
              </p>
            </div>

            {/* UPLOAD CARD */}
            <div className="mx-auto max-w-4xl rounded-3xl border border-slate-200 bg-white p-6 shadow-sm sm:p-8">
              {!image ? (
                <label className="flex min-h-64 cursor-pointer flex-col items-center justify-center rounded-2xl border-2 border-dashed border-indigo-200 bg-indigo-50/40 px-6 text-center transition hover:border-indigo-400 hover:bg-indigo-50">
                  <div className="flex h-16 w-16 items-center justify-center rounded-2xl bg-white text-indigo-600 shadow-sm">
                    <ImageIcon size={30} />
                  </div>

                  <h3 className="mt-5 text-xl font-bold text-slate-900">
                    Upload Question Image
                  </h3>

                  <p className="mt-2 max-w-md text-sm leading-6 text-slate-500">
                    Choose an image containing your JEE or NEET question.
                    PNG, JPG and JPEG images are supported.
                  </p>

                  <span className="mt-6 inline-flex items-center gap-2 rounded-xl bg-indigo-600 px-6 py-3 text-sm font-semibold text-white shadow-lg shadow-indigo-200 transition hover:bg-indigo-700">
                    <Upload size={18} />
                    Choose Image
                  </span>

                  <input
                    type="file"
                    accept="image/png,image/jpeg,image/jpg"
                    onChange={handleImageUpload}
                    className="hidden"
                  />
                </label>
              ) : (
                <div>
                  <div className="relative overflow-hidden rounded-2xl border border-slate-200 bg-slate-50 p-4">
                    <img
                      src={image}
                      alt="Uploaded question"
                      className="mx-auto max-h-[500px] max-w-full rounded-xl object-contain"
                    />

                    <button
                      type="button"
                      onClick={removeImage}
                      className="absolute right-6 top-6 flex h-10 w-10 items-center justify-center rounded-full bg-white text-slate-700 shadow-md transition hover:bg-red-50 hover:text-red-500"
                    >
                      <X size={19} />
                    </button>
                  </div>

                  <div className="mt-5 flex items-center justify-between rounded-xl bg-emerald-50 px-4 py-3">
                    <div className="flex items-center gap-2 text-sm font-semibold text-emerald-700">
                      <ImageIcon size={18} />
                      Question image uploaded
                    </div>

                    <button
                      type="button"
                      onClick={removeImage}
                      className="text-sm font-semibold text-red-500 hover:text-red-600"
                    >
                      Remove
                    </button>
                  </div>
                </div>
              )}

              {/* SUBJECT */}
              <div className="mt-8">
                <label className="mb-2 block text-sm font-semibold text-slate-700">
                  Select Subject
                </label>

                <select
                  value={subject}
                  onChange={(e) => setSubject(e.target.value)}
                  className="w-full rounded-xl border border-slate-200 bg-white px-4 py-3 text-sm font-medium text-slate-700 outline-none transition focus:border-indigo-500 focus:ring-4 focus:ring-indigo-100"
                >
                  <option>Physics</option>
                  <option>Chemistry</option>
                  <option>Mathematics</option>
                  <option>Biology</option>
                </select>
              </div>

              {/* OPTIONAL TEXT */}
              <div className="mt-6">
                <label className="mb-2 block text-sm font-semibold text-slate-700">
                  Add details{" "}
                  <span className="font-normal text-slate-400">
                    (optional)
                  </span>
                </label>

                <textarea
                  value={question}
                  onChange={(e) => setQuestion(e.target.value)}
                  rows={4}
                  placeholder="Add anything you want Arogya-AI to focus on..."
                  className="w-full resize-none rounded-xl border border-slate-200 bg-white px-4 py-3 text-sm text-slate-700 outline-none transition placeholder:text-slate-400 focus:border-indigo-500 focus:ring-4 focus:ring-indigo-100"
                />
              </div>

              {/* SOLVE BUTTON */}
              <button
                type="button"
                onClick={handleSolve}
                disabled={solving || (!image && !question.trim())}
                className="mt-6 flex w-full items-center justify-center gap-2 rounded-xl bg-indigo-600 px-6 py-4 text-sm font-bold text-white shadow-lg shadow-indigo-200 transition hover:bg-indigo-700 disabled:cursor-not-allowed disabled:opacity-50"
              >
                <Sparkles size={19} />

                {solving ? "Arogya-AI is solving..." : "Solve with AI"}

                {!solving && <Send size={18} />}
              </button>
            </div>

            {/* SOLUTION */}
            {solution && (
              <div className="mx-auto mt-8 max-w-4xl rounded-3xl border border-indigo-100 bg-white p-6 shadow-sm sm:p-8">
                <div className="flex items-center gap-3">
                  <div className="flex h-11 w-11 items-center justify-center rounded-xl bg-indigo-100 text-indigo-600">
                    <Sparkles size={22} />
                  </div>

                  <div>
                    <h3 className="font-bold text-slate-900">
                      AI Solution
                    </h3>

                    <p className="text-sm text-slate-500">
                      {solution.subject} • Step-by-step explanation
                    </p>
                  </div>
                </div>

                <div className="mt-7 space-y-5">
                  {solution.steps.map((step, index) => (
                    <div key={index} className="flex gap-4">
                      <div className="flex h-8 w-8 shrink-0 items-center justify-center rounded-lg bg-indigo-600 text-xs font-bold text-white">
                        {String(index + 1).padStart(2, "0")}
                      </div>

                      <div>
                        <h4 className="font-semibold text-slate-900">
                          Step {index + 1}
                        </h4>

                        <p className="mt-1 text-sm leading-6 text-slate-500">
                          {step}
                        </p>
                      </div>
                    </div>
                  ))}
                </div>

                <div className="mt-7 rounded-xl bg-indigo-50 px-5 py-4 text-center font-bold text-indigo-700">
                  Final answer will appear here after connecting the AI
                  backend.
                </div>
              </div>
            )}
          </div>
        ) : (
          /* ================= NORMAL ASSISTANT MODE ================= */
          <div>
            <div className="text-center">
              <div className="mx-auto flex h-16 w-16 items-center justify-center rounded-2xl bg-indigo-600 text-white shadow-lg shadow-indigo-200">
                <Sparkles size={30} />
              </div>

              <h2 className="mt-6 text-4xl font-bold text-slate-900">
                What do you want to solve?
              </h2>

              <p className="mx-auto mt-3 max-w-2xl text-slate-500">
                Ask any complex JEE or NEET question. Arogya-AI will break it
                down into clear, step-by-step explanations.
              </p>
            </div>

            {/* EXAMPLE QUESTIONS */}
            <div className="mt-10 grid gap-5 md:grid-cols-3">
              <button
                type="button"
                onClick={() =>
                  setQuestion("Explain rotational motion step by step")
                }
                className="rounded-2xl border border-slate-200 bg-white p-6 text-left transition hover:-translate-y-1 hover:border-indigo-200 hover:shadow-lg"
              >
                <p className="text-sm font-bold text-indigo-600">PHYSICS</p>

                <p className="mt-3 font-semibold leading-6 text-slate-900">
                  Explain rotational motion step by step
                </p>
              </button>

              <button
                type="button"
                onClick={() =>
                  setQuestion("Solve this organic reaction mechanism")
                }
                className="rounded-2xl border border-slate-200 bg-white p-6 text-left transition hover:-translate-y-1 hover:border-indigo-200 hover:shadow-lg"
              >
                <p className="text-sm font-bold text-indigo-600">CHEMISTRY</p>

                <p className="mt-3 font-semibold leading-6 text-slate-900">
                  Solve this organic reaction mechanism
                </p>
              </button>

              <button
                type="button"
                onClick={() =>
                  setQuestion("Find the solution of this integral")
                }
                className="rounded-2xl border border-slate-200 bg-white p-6 text-left transition hover:-translate-y-1 hover:border-indigo-200 hover:shadow-lg"
              >
                <p className="text-sm font-bold text-indigo-600">
                  MATHEMATICS
                </p>

                <p className="mt-3 font-semibold leading-6 text-slate-900">
                  Find the solution of this integral
                </p>
              </button>
            </div>

            {/* QUESTION BOX */}
            <div className="mx-auto mt-10 max-w-4xl rounded-2xl border border-slate-200 bg-white p-3 shadow-sm">
              <div className="flex items-end gap-3">
                <textarea
                  value={question}
                  onChange={(e) => setQuestion(e.target.value)}
                  rows={3}
                  placeholder="Ask a JEE or NEET question..."
                  className="min-h-20 flex-1 resize-none border-0 bg-transparent px-3 py-3 text-sm text-slate-700 outline-none placeholder:text-slate-400"
                />

                <button
                  type="button"
                  onClick={handleSolve}
                  disabled={!question.trim()}
                  className="flex h-12 w-12 shrink-0 items-center justify-center rounded-xl bg-indigo-600 text-white transition hover:bg-indigo-700 disabled:cursor-not-allowed disabled:opacity-40"
                >
                  <Send size={20} />
                </button>
              </div>
            </div>

            {/* QUICK UPLOAD */}
            <div className="mx-auto mt-5 flex max-w-4xl justify-center">
              <Link
                to="/ai-assistant?upload=true"
                className="inline-flex items-center gap-2 rounded-xl border border-slate-200 bg-white px-5 py-3 text-sm font-semibold text-slate-600 transition hover:border-indigo-200 hover:bg-indigo-50 hover:text-indigo-600"
              >
                <Upload size={17} />
                Upload a Question Image
              </Link>
            </div>

            {/* INFO */}
            <div className="mt-8 flex flex-wrap justify-center gap-5 text-sm text-slate-400">
              <span className="flex items-center gap-2">
                <MessageSquare size={16} />
                Step-by-step explanations
              </span>

              <span className="flex items-center gap-2">
                <BookOpen size={16} />
                JEE & NEET focused
              </span>
            </div>

            {/* NORMAL SOLUTION */}
            {solution && (
              <div className="mx-auto mt-8 max-w-4xl rounded-2xl border border-indigo-100 bg-white p-7 shadow-sm">
                <div className="flex items-center gap-3">
                  <Sparkles className="text-indigo-600" size={22} />

                  <div>
                    <h3 className="font-bold text-slate-900">
                      AI Solution
                    </h3>

                    <p className="text-sm text-slate-500">
                      Step-by-step explanation
                    </p>
                  </div>
                </div>

                <div className="mt-6 space-y-4">
                  {solution.steps.map((step, index) => (
                    <div key={index} className="flex gap-3">
                      <span className="flex h-7 w-7 shrink-0 items-center justify-center rounded-lg bg-indigo-600 text-xs font-bold text-white">
                        {index + 1}
                      </span>

                      <p className="pt-1 text-sm text-slate-600">{step}</p>
                    </div>
                  ))}
                </div>
              </div>
            )}
          </div>
        )}
      </main>
    </div>
  );
}

export default AIAssistant;