import { Link } from "react-router-dom";
import {
  ArrowLeft,
  AlertTriangle,
  Brain,
  ChevronRight,
  RotateCcw,
  CheckCircle2,
} from "lucide-react";

function Mistakes() {
  const mistakes = [
    {
      subject: "Physics",
      topic: "Rotational Motion",
      question: "A disc is rotating about its central axis. Find its angular momentum.",
      difficulty: "Hard",
      concept: "Moment of Inertia",
    },
    {
      subject: "Chemistry",
      topic: "Organic Chemistry",
      question: "Identify the major product of the given organic reaction.",
      difficulty: "Medium",
      concept: "Reaction Mechanism",
    },
    {
      subject: "Mathematics",
      topic: "Integration",
      question: "Evaluate the given definite integral using the appropriate method.",
      difficulty: "Hard",
      concept: "Definite Integration",
    },
    {
      subject: "Biology",
      topic: "Human Physiology",
      question: "Which part of the nephron is mainly responsible for reabsorption?",
      difficulty: "Medium",
      concept: "Excretory System",
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

        {/* Heading */}
        <div className="mb-8">

          <div className="mb-4 flex h-12 w-12 items-center justify-center rounded-xl bg-red-50 text-red-500">
            <AlertTriangle size={25} />
          </div>

          <h2 className="text-3xl font-extrabold tracking-tight">
            Learn From Your Mistakes
          </h2>

          <p className="mt-2 max-w-2xl text-slate-500">
            Review questions you got wrong, understand the concepts behind
            them, and improve your problem-solving accuracy.
          </p>

        </div>

        {/* Stats */}
        <div className="mb-8 grid gap-5 md:grid-cols-3">

          <div className="rounded-2xl border border-slate-200 bg-white p-6">
            <p className="text-sm font-semibold text-slate-500">
              Total Mistakes
            </p>

            <h3 className="mt-3 text-3xl font-extrabold">
              24
            </h3>

            <p className="mt-1 text-sm text-slate-400">
              Questions to review
            </p>
          </div>

          <div className="rounded-2xl border border-slate-200 bg-white p-6">
            <p className="text-sm font-semibold text-slate-500">
              Concepts to Improve
            </p>

            <h3 className="mt-3 text-3xl font-extrabold">
              8
            </h3>

            <p className="mt-1 text-sm text-slate-400">
              Based on your attempts
            </p>
          </div>

          <div className="rounded-2xl border border-slate-200 bg-white p-6">
            <p className="text-sm font-semibold text-slate-500">
              Improved
            </p>

            <h3 className="mt-3 text-3xl font-extrabold text-emerald-600">
              16
            </h3>

            <p className="mt-1 text-sm text-slate-400">
              Mistakes corrected
            </p>
          </div>

        </div>

        {/* Mistakes */}
        <section>

          <div className="mb-5 flex items-center justify-between">
            <div>
              <h3 className="text-xl font-extrabold">
                Questions to Review
              </h3>

              <p className="mt-1 text-sm text-slate-500">
                Focus on these concepts to strengthen your preparation.
              </p>
            </div>

            <button
              type="button"
              className="hidden items-center gap-2 rounded-xl border border-slate-200 bg-white px-4 py-2.5 text-sm font-semibold text-slate-600 transition hover:bg-slate-50 sm:flex"
            >
              <RotateCcw size={16} />
              Review All
            </button>
          </div>

          <div className="space-y-4">

            {mistakes.map((mistake, index) => (
              <div
                key={index}
                className="rounded-2xl border border-slate-200 bg-white p-6 transition hover:-translate-y-0.5 hover:border-indigo-200 hover:shadow-lg hover:shadow-slate-200/50"
              >

                <div className="flex flex-col gap-5 md:flex-row md:items-center md:justify-between">

                  <div className="flex gap-4">

                    <div className="flex h-11 w-11 shrink-0 items-center justify-center rounded-xl bg-red-50 text-red-500">
                      <AlertTriangle size={20} />
                    </div>

                    <div>

                      <div className="mb-2 flex flex-wrap items-center gap-2">

                        <span className="rounded-md bg-indigo-50 px-2.5 py-1 text-xs font-bold text-indigo-600">
                          {mistake.subject}
                        </span>

                        <span className="text-xs font-semibold text-slate-400">
                          {mistake.topic}
                        </span>

                        <span className="rounded-md bg-red-50 px-2.5 py-1 text-xs font-bold text-red-500">
                          {mistake.difficulty}
                        </span>

                      </div>

                      <h4 className="max-w-3xl font-bold leading-6 text-slate-800">
                        {mistake.question}
                      </h4>

                      <p className="mt-2 text-sm text-slate-500">
                        Concept:{" "}
                        <span className="font-semibold text-slate-700">
                          {mistake.concept}
                        </span>
                      </p>

                    </div>

                  </div>

                  <Link
                    to="/ai-assistant"
                    className="flex shrink-0 items-center justify-center gap-2 rounded-xl bg-indigo-600 px-4 py-2.5 text-sm font-bold text-white transition hover:bg-indigo-700"
                  >
                    Review Solution
                    <ChevronRight size={16} />
                  </Link>

                </div>

              </div>
            ))}

          </div>

        </section>

        {/* Learning tip */}
        <div className="mt-8 rounded-2xl border border-indigo-100 bg-indigo-50 p-6">

          <div className="flex items-start gap-4">

            <div className="flex h-10 w-10 shrink-0 items-center justify-center rounded-xl bg-white text-indigo-600">
              <Brain size={20} />
            </div>

            <div>
              <h3 className="font-bold text-slate-800">
                Mistakes are part of learning
              </h3>

              <p className="mt-1 text-sm leading-6 text-slate-500">
                Don't just memorise the correct answer. Understand why your
                previous approach was incorrect and learn the underlying
                concept.
              </p>
            </div>

          </div>

        </div>

      </main>
    </div>
  );
}

export default Mistakes;