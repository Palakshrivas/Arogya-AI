import { Link } from "react-router-dom";
import {
  ArrowLeft,
  History as HistoryIcon,
  Search,
  CheckCircle2,
  ChevronRight,
  Trash2,
} from "lucide-react";

function History() {
  const questions = [
    {
      subject: "Physics",
      title: "A body is projected vertically upward with an initial velocity of 20 m/s.",
      topic: "Kinematics",
      time: "Today, 10:32 AM",
    },
    {
      subject: "Chemistry",
      title: "Explain the mechanism of this organic reaction step by step.",
      topic: "Organic Chemistry",
      time: "Yesterday, 6:45 PM",
    },
    {
      subject: "Mathematics",
      title: "Find the solution of the given definite integral.",
      topic: "Integration",
      time: "Yesterday, 3:20 PM",
    },
    {
      subject: "Biology",
      title: "Explain the process of photosynthesis and its important stages.",
      topic: "Plant Physiology",
      time: "2 days ago",
    },
  ];

  return (
    <div className="min-h-screen bg-slate-50 text-slate-900">

      {/* Header */}
      <header className="border-b border-slate-200 bg-white">
        <div className="mx-auto flex max-w-7xl items-center justify-between px-6 py-5">

          <div>
            <h1 className="text-2xl font-extrabold">
              Arogya<span className="text-indigo-600">-AI</span>
            </h1>

            <p className="text-xs font-semibold tracking-widest text-slate-400">
              LEARN • SOLVE • MASTER
            </p>
          </div>

          <Link
            to="/"
            className="flex items-center gap-2 rounded-xl border border-slate-200 bg-white px-4 py-2.5 text-sm font-semibold text-slate-700 transition hover:bg-slate-50"
          >
            <ArrowLeft size={17} />
            Back to Home
          </Link>

        </div>
      </header>

      {/* Main */}
      <main className="mx-auto max-w-7xl px-6 py-10">

        {/* Page heading */}
        <div className="mb-8">

          <div className="mb-4 flex h-12 w-12 items-center justify-center rounded-xl bg-indigo-100 text-indigo-600">
            <HistoryIcon size={25} />
          </div>

          <h2 className="text-3xl font-extrabold tracking-tight">
            Solution History
          </h2>

          <p className="mt-2 text-slate-500">
            Revisit questions you have solved with Arogya-AI.
          </p>

        </div>

        {/* Search + filter */}
        <div className="mb-6 flex flex-col gap-3 sm:flex-row">

          <div className="relative flex-1">
            <Search
              size={19}
              className="absolute left-4 top-1/2 -translate-y-1/2 text-slate-400"
            />

            <input
              type="text"
              placeholder="Search your solved questions..."
              className="w-full rounded-xl border border-slate-200 bg-white py-3 pl-11 pr-4 text-sm outline-none transition focus:border-indigo-400 focus:ring-4 focus:ring-indigo-100"
            />
          </div>

          <select className="rounded-xl border border-slate-200 bg-white px-4 py-3 text-sm font-semibold text-slate-600 outline-none">
            <option>All Subjects</option>
            <option>Physics</option>
            <option>Chemistry</option>
            <option>Mathematics</option>
            <option>Biology</option>
          </select>

        </div>

        {/* History list */}
        <div className="space-y-4">

          {questions.map((question, index) => (
            <div
              key={index}
              className="group rounded-2xl border border-slate-200 bg-white p-6 transition duration-300 hover:-translate-y-0.5 hover:border-indigo-200 hover:shadow-lg hover:shadow-slate-200/50"
            >

              <div className="flex flex-col gap-5 md:flex-row md:items-center md:justify-between">

                {/* Question info */}
                <div className="flex gap-4">

                  <div className="mt-1 flex h-10 w-10 shrink-0 items-center justify-center rounded-xl bg-indigo-50 text-indigo-600">
                    <CheckCircle2 size={20} />
                  </div>

                  <div>

                    <div className="mb-2 flex flex-wrap items-center gap-2">

                      <span className="rounded-md bg-indigo-50 px-2.5 py-1 text-xs font-bold text-indigo-600">
                        {question.subject}
                      </span>

                      <span className="text-xs font-medium text-slate-400">
                        {question.topic}
                      </span>

                    </div>

                    <h3 className="max-w-3xl text-base font-bold leading-6 text-slate-800">
                      {question.title}
                    </h3>

                    <p className="mt-2 text-xs text-slate-400">
                      {question.time}
                    </p>

                  </div>

                </div>

                {/* Actions */}
                <div className="flex items-center gap-2 md:ml-4">

                  <Link
                    to="/ai-assistant"
                    className="flex items-center gap-2 rounded-xl border border-slate-200 px-4 py-2.5 text-sm font-bold text-slate-700 transition hover:border-indigo-200 hover:bg-indigo-50 hover:text-indigo-600"
                  >
                    View Solution
                    <ChevronRight size={16} />
                  </Link>

                  <button
                    type="button"
                    className="flex h-10 w-10 items-center justify-center rounded-xl text-slate-400 transition hover:bg-red-50 hover:text-red-500"
                    title="Delete"
                  >
                    <Trash2 size={17} />
                  </button>

                </div>

              </div>

            </div>
          ))}

        </div>

        {/* Empty/future info */}
        <div className="mt-8 rounded-2xl border border-indigo-100 bg-indigo-50 p-6">

          <div className="flex items-start gap-4">

            <div className="flex h-10 w-10 shrink-0 items-center justify-center rounded-xl bg-white text-indigo-600">
              <HistoryIcon size={19} />
            </div>

            <div>
              <h3 className="font-bold text-slate-800">
                Your solutions stay organised
              </h3>

              <p className="mt-1 text-sm leading-6 text-slate-500">
                Use your history to revisit difficult questions, review
                concepts, and improve your problem-solving skills.
              </p>
            </div>

          </div>

        </div>

      </main>
    </div>
  );
}

export default History;