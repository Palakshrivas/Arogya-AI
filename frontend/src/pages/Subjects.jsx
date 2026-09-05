import { Link } from "react-router-dom";
import {
  ArrowLeft,
  Atom,
  FlaskConical,
  Calculator,
  Dna,
  ChevronRight,
  Sparkles,
} from "lucide-react";

function Subjects() {
  const subjects = [
    {
      name: "Physics",
      description:
        "Master mechanics, electricity, optics, thermodynamics and more with step-by-step solutions.",
      topics: "Mechanics • Electrodynamics • Optics",
      icon: <Atom size={25} />,
      questions: "120+ Questions",
    },
    {
      name: "Chemistry",
      description:
        "Understand physical, organic and inorganic chemistry with concept-focused explanations.",
      topics: "Organic • Inorganic • Physical",
      icon: <FlaskConical size={25} />,
      questions: "150+ Questions",
    },
    {
      name: "Mathematics",
      description:
        "Build strong problem-solving skills across algebra, calculus, geometry and more.",
      topics: "Algebra • Calculus • Geometry",
      icon: <Calculator size={25} />,
      questions: "180+ Questions",
    },
    {
      name: "Biology",
      description:
        "Learn biology concepts clearly with explanations designed for NEET preparation.",
      topics: "Botany • Zoology • Human Biology",
      icon: <Dna size={25} />,
      questions: "160+ Questions",
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
        <div className="mb-10">

          <div className="mb-4 flex h-12 w-12 items-center justify-center rounded-xl bg-indigo-100 text-indigo-600">
            <Sparkles size={24} />
          </div>

          <h2 className="text-3xl font-extrabold tracking-tight">
            Choose Your Subject
          </h2>

          <p className="mt-2 max-w-2xl text-slate-500">
            Select a subject and start solving complex JEE & NEET questions
            with clear, step-by-step AI explanations.
          </p>

        </div>

        {/* Subject Cards */}
        <div className="grid gap-6 md:grid-cols-2">

          {subjects.map((subject, index) => (
            <div
              key={index}
              className="group rounded-2xl border border-slate-200 bg-white p-7 transition duration-300 hover:-translate-y-1 hover:border-indigo-200 hover:shadow-xl hover:shadow-slate-200/50"
            >

              {/* Top */}
              <div className="flex items-start justify-between">

                <div className="flex h-12 w-12 items-center justify-center rounded-xl bg-indigo-50 text-indigo-600 transition group-hover:bg-indigo-600 group-hover:text-white">
                  {subject.icon}
                </div>

                <span className="rounded-full bg-slate-100 px-3 py-1 text-xs font-bold text-slate-500">
                  {subject.questions}
                </span>

              </div>

              {/* Content */}
              <h3 className="mt-6 text-xl font-extrabold">
                {subject.name}
              </h3>

              <p className="mt-2 text-sm leading-6 text-slate-500">
                {subject.description}
              </p>

              <p className="mt-4 text-xs font-bold text-indigo-600">
                {subject.topics}
              </p>

              {/* Button */}
              <Link
                to="/ai-assistant"
                className="mt-6 flex w-full items-center justify-center gap-2 rounded-xl bg-slate-900 px-5 py-3 text-sm font-bold text-white transition hover:bg-indigo-600"
              >
                Start {subject.name}
                <ChevronRight
                  size={17}
                  className="transition group-hover:translate-x-1"
                />
              </Link>

            </div>
          ))}

        </div>

        {/* Bottom CTA */}
        <div className="mt-8 rounded-2xl bg-indigo-600 p-7 text-white shadow-xl shadow-indigo-200">

          <div className="flex flex-col items-start justify-between gap-5 md:flex-row md:items-center">

            <div>
              <h3 className="text-xl font-extrabold">
                Have a difficult question?
              </h3>

              <p className="mt-1 text-sm text-indigo-100">
                Let Arogya-AI break it down into simple, understandable steps.
              </p>
            </div>

            <Link
              to="/ai-assistant"
              className="flex items-center gap-2 rounded-xl bg-white px-5 py-3 text-sm font-bold text-indigo-600 transition hover:bg-indigo-50"
            >
              Ask AI
              <Sparkles size={17} />
            </Link>

          </div>

        </div>

      </main>
    </div>
  );
}

export default Subjects;