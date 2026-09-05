

import { Link } from "react-router-dom";
import {
  ArrowRight,
  Atom,
  BarChart3,
  BookOpen,
  Brain,
  CheckCircle2,
  ChevronRight,
  Clock3,
  FileImage,
  FlaskConical,
  GraduationCap,
  History,
  Menu,
  MessageSquare,
  Moon,
  Sun,
  Play,
  Plus,
  Sparkles,
  Target,
  Trophy,
  Upload,
  Users,
  X,
} from "lucide-react";
import { useState,useEffect  } from "react";

function Home() {
  const [menuOpen, setMenuOpen] = useState(false);
  const [darkMode, setDarkMode] = useState(() => {
  return localStorage.getItem("theme") === "dark";
});

useEffect(() => {
  document.documentElement.classList.toggle("dark-mode", darkMode);
  localStorage.setItem("theme", darkMode ? "dark" : "light");
}, [darkMode]);

  return (
    <div className="min-h-screen bg-[#f8fafc] text-slate-950">

      {/* =====================================================
          NAVBAR
      ===================================================== */}
      <header className="sticky top-0 z-50 border-b border-slate-200/80 bg-white/90 backdrop-blur-xl">
        <div className="mx-auto flex h-[76px] max-w-7xl items-center justify-between px-5 sm:px-8">

          {/* Logo */}
          <a href="#" className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center rounded-xl bg-indigo-600 text-white shadow-lg shadow-indigo-200">
              <Brain size={21} strokeWidth={2.5} />
            </div>

            <div>
              <div className="text-lg font-extrabold tracking-tight">
                Arogya<span className="text-indigo-600">-AI</span>
              </div>

              <div className="text-[9px] font-bold uppercase tracking-[0.18em] text-slate-400">
                Learn • Solve • Master
              </div>
            </div>
          </a>

          {/* Desktop Navigation */}
          <nav className="hidden items-center gap-8 lg:flex">
            <a
              href="#home"
              className="text-sm font-semibold text-indigo-600"
            >
              Home
            </a>

            <a
              href="#subjects"
              className="text-sm font-medium text-slate-500 transition hover:text-indigo-600"
            >
              Subjects
            </a>

            <a
              href="#features"
              className="text-sm font-medium text-slate-500 transition hover:text-indigo-600"
            >
              Features
            </a>

            <a
              href="#how-it-works"
              className="text-sm font-medium text-slate-500 transition hover:text-indigo-600"
            >
              How it works
            </a>

            <a
              href="#about"
              className="text-sm font-medium text-slate-500 transition hover:text-indigo-600"
            >
              About
            </a>
          </nav>

          {/* Right */}
          <div className="flex items-center gap-3">

           <button
                onClick={() => setDarkMode(!darkMode)}
                aria-label="Toggle dark mode"
                className="flex h-12 w-12 items-center justify-center rounded-xl border border-slate-200 bg-white text-slate-600 shadow-sm transition-all duration-300 hover:bg-slate-50 hover:text-indigo-600 dark-toggle"
                >
                {darkMode ? (
                    <Sun size={21} />
                ) : (
                    <Moon size={21} />
                )}
                </button>
            <Link
  to="/login"
  className="hidden rounded-xl px-4 py-2.5 text-sm font-semibold text-slate-700 transition hover:bg-slate-100 sm:block"
>
  Sign In
</Link>

            <button className="hidden rounded-xl bg-slate-950 px-5 py-2.5 text-sm font-bold text-white shadow-lg transition hover:bg-slate-800 sm:block">
              Get Started
            </button>

            <button
              onClick={() => setMenuOpen(!menuOpen)}
              className="flex h-10 w-10 items-center justify-center rounded-xl border border-slate-200 lg:hidden"
            >
              {menuOpen ? <X size={19} /> : <Menu size={19} />}
            </button>
          </div>
        </div>

        {/* Mobile menu */}
        {menuOpen && (
          <div className="border-t border-slate-100 bg-white px-5 py-5 lg:hidden">
            <div className="flex flex-col gap-4">
              <a href="#home" className="font-semibold text-indigo-600">
                Home
              </a>
              <a href="#subjects" className="text-slate-600">
                Subjects
              </a>
              <a href="#features" className="text-slate-600">
                Features
              </a>
              <a href="#how-it-works" className="text-slate-600">
                How it works
              </a>
              <a href="#about" className="text-slate-600">
                About
              </a>
            </div>
          </div>
        )}
      </header>


      {/* =====================================================
          HERO
      ===================================================== */}
      <section id="home" className="relative overflow-hidden">

        <div className="absolute -left-40 top-20 h-[500px] w-[500px] rounded-full bg-indigo-100/50 blur-3xl" />
        <div className="absolute -right-40 top-40 h-[500px] w-[500px] rounded-full bg-violet-100/40 blur-3xl" />

        <div className="relative mx-auto grid max-w-7xl items-center gap-14 px-5 py-16 sm:px-8 lg:grid-cols-[1.05fr_0.95fr] lg:py-24">

          {/* Hero Left */}
          <div>

            <div className="mb-7 inline-flex items-center gap-2 rounded-full border border-indigo-100 bg-indigo-50 px-4 py-2">
              <Sparkles size={14} className="text-indigo-600" />
              <span className="text-xs font-bold text-indigo-700">
                AI-powered JEE & NEET preparation
              </span>
            </div>

            <h1 className="max-w-3xl text-5xl font-black leading-[1.03] tracking-[-0.04em] text-slate-950 sm:text-6xl lg:text-[68px]">
              Don't just get the answer.
              <span className="mt-3 block text-indigo-600">
                Understand it.
              </span>
            </h1>

            <p className="mt-7 max-w-xl text-base leading-7 text-slate-600 sm:text-lg">
              Arogya-AI helps JEE and NEET aspirants solve complex problems
              with intelligent, step-by-step explanations — so you learn the
              concept, not just the answer.
            </p>

            <div className="mt-9 flex flex-col gap-3 sm:flex-row">

              <Link
            to="/ai-assistant"className="group flex items-center justify-center gap-2 rounded-xl bg-indigo-600 px-6 py-3.5 text-sm font-bold text-white shadow-xl shadow-indigo-200 transition hover:-translate-y-0.5 hover:bg-indigo-700"
>Start Solving
  <ArrowRight
    size={17}
    className="transition group-hover:translate-x-1"
  />
</Link>

              <button className="flex items-center justify-center gap-2 rounded-xl border border-slate-200 bg-white px-6 py-3.5 text-sm font-bold text-slate-700 transition hover:border-slate-300 hover:bg-slate-50">
                <Play size={15} fill="currentColor" />
                See how it works
              </button>

            </div>

            {/* Trust */}
            <div className="mt-10 flex flex-wrap items-center gap-6 text-sm text-slate-500">
              <div className="flex items-center gap-2">
                <CheckCircle2 size={17} className="text-emerald-500" />
                Step-by-step solutions
              </div>

              <div className="flex items-center gap-2">
                <CheckCircle2 size={17} className="text-emerald-500" />
                JEE & NEET focused
              </div>
            </div>

          </div>


          {/* AI Solver Preview */}
          <div className="relative">

            <div className="absolute -inset-5 rounded-[2rem] bg-indigo-100/60 blur-3xl" />

            <div className="relative overflow-hidden rounded-[1.5rem] border border-slate-200 bg-white shadow-2xl shadow-slate-300/40">

              {/* Window header */}
              <div className="flex items-center justify-between border-b border-slate-100 px-5 py-4">

                <div className="flex items-center gap-3">

                  <div className="flex h-9 w-9 items-center justify-center rounded-lg bg-indigo-50 text-indigo-600">
                    <Brain size={18} />
                  </div>

                  <div>
                    <p className="text-sm font-bold">
                      Arogya AI Solver
                    </p>
                    <p className="text-[11px] text-slate-400">
                      Your intelligent study partner
                    </p>
                  </div>

                </div>

                <div className="flex items-center gap-1.5 rounded-full bg-emerald-50 px-3 py-1.5">
                  <span className="h-1.5 w-1.5 rounded-full bg-emerald-500" />
                  <span className="text-[10px] font-bold text-emerald-600">
                    Online
                  </span>
                </div>

              </div>


              {/* Question */}
              <div className="p-5">

                <div className="rounded-xl border border-slate-200 bg-slate-50 p-4">

                  <div className="flex items-center justify-between">

                    <span className="rounded-md bg-indigo-100 px-2.5 py-1 text-[10px] font-extrabold text-indigo-700">
                      JEE • PHYSICS
                    </span>

                    <span className="text-[11px] font-medium text-slate-400">
                      Question
                    </span>

                  </div>

                  <p className="mt-4 text-sm font-semibold leading-6 text-slate-700">
                    A body is projected vertically upward with an initial
                    velocity of 20 m/s. Find the maximum height reached by
                    the body.
                  </p>

                </div>


                {/* AI thinking */}
                <div className="mt-4 flex items-center gap-2 text-xs font-semibold text-indigo-600">
                  <Sparkles size={14} />
                  Arogya is solving this step by step...
                </div>


                {/* Solution */}
                <div className="mt-4 rounded-xl border border-indigo-100 bg-indigo-50/50 p-4">

                  <div className="flex items-center gap-2 text-xs font-bold text-indigo-700">
                    <MessageSquare size={14} />
                    Solution
                  </div>

                  <div className="mt-4 space-y-3">

                    <SolutionStep
                      number="01"
                      title="Identify the given values"
                      text="Initial velocity u = 20 m/s and acceleration due to gravity g = 9.8 m/s²."
                    />

                    <SolutionStep
                      number="02"
                      title="Choose the correct equation"
                      text="At maximum height, final velocity becomes zero. Use v² = u² − 2gh."
                    />

                    <SolutionStep
                      number="03"
                      title="Substitute the values"
                      text="0 = (20)² − 2(9.8)h"
                    />

                  </div>

                  <div className="mt-4 rounded-lg bg-white px-4 py-3 text-center">
                    <span className="text-sm font-extrabold text-indigo-700">
                      Maximum Height ≈ 20.4 m
                    </span>
                  </div>

                </div>

              </div>

            </div>

          </div>

        </div>
      </section>


      {/* =====================================================
          STATS
      ===================================================== */}
      <section className="border-y border-slate-200 bg-white">

        <div className="mx-auto grid max-w-7xl grid-cols-2 divide-x divide-slate-200 sm:grid-cols-4">

          <Stat value="JEE" label="Engineering entrance" />
          <Stat value="NEET" label="Medical entrance" />
          <Stat value="24/7" label="AI assistance" />
          <Stat value="∞" label="Problems to explore" />

        </div>

      </section>


      {/* =====================================================
          SUBJECTS
      ===================================================== */}
      <section id="subjects" className="bg-[#f8fafc]">

        <div className="mx-auto max-w-7xl px-5 py-20 sm:px-8">

          <div className="flex flex-col justify-between gap-6 md:flex-row md:items-end">

            <div className="max-w-2xl">

              <p className="text-xs font-extrabold uppercase tracking-[0.2em] text-indigo-600">
                Prepare smarter
              </p>

              <h2 className="mt-3 text-3xl font-black tracking-tight sm:text-4xl">
                Everything you need for your preparation.
              </h2>

              <p className="mt-4 leading-7 text-slate-500">
                Ask questions from the subjects that matter most for your
                JEE and NEET journey.
              </p>

            </div>

            <button className="flex items-center gap-1 text-sm font-bold text-indigo-600">
              Explore all subjects
              <ChevronRight size={16} />
            </button>

          </div>


          <div className="mt-10 grid gap-5 sm:grid-cols-2 lg:grid-cols-4">

            <SubjectCard
              icon={<Atom size={22} />}
              title="Physics"
              exam="JEE • NEET"
              description="Mechanics, electricity, optics, modern physics and more."
            />

            <SubjectCard
              icon={<FlaskConical size={22} />}
              title="Chemistry"
              exam="JEE • NEET"
              description="Physical, organic and inorganic chemistry concepts."
            />

            <SubjectCard
              icon={<Target size={22} />}
              title="Mathematics"
              exam="JEE"
              description="Algebra, calculus, geometry, probability and more."
            />

            <SubjectCard
              icon={<BookOpen size={22} />}
              title="Biology"
              exam="NEET"
              description="Botany, zoology, human physiology and genetics."
            />

          </div>

        </div>

      </section>


      {/* =====================================================
          FEATURES
      ===================================================== */}
      <section id="features" className="border-y border-slate-200 bg-white">

        <div className="mx-auto max-w-7xl px-5 py-20 sm:px-8">

          <div className="mx-auto max-w-2xl text-center">

            <p className="text-xs font-extrabold uppercase tracking-[0.2em] text-indigo-600">
              Why Arogya-AI
            </p>

            <h2 className="mt-3 text-3xl font-black tracking-tight sm:text-4xl">
              Built around how students actually learn.
            </h2>

            <p className="mt-4 leading-7 text-slate-500">
              Every feature is designed to help you understand difficult
              concepts faster and prepare with confidence.
            </p>

          </div>


          <div className="mt-12 grid gap-5 md:grid-cols-2 lg:grid-cols-3">

            <FeatureCard
                icon={<Brain size={21} />}
                title="Step-by-Step Solutions"
                text="Understand the complete solving process instead of memorising the final answer."
                to="/ai-assistant"
            />

           <FeatureCard
                icon={<Upload size={21} />}
                title="Upload Any Question"
                text="Upload a question image or enter it directly and let AI analyse the problem."
                to="/ai-assistant?upload=true"
                />

            <FeatureCard
              icon={<Target size={21} />}
              title="Exam Focused"
              text="Solutions are structured around JEE and NEET level concepts and patterns."
               to="/subjects"
            />

            <FeatureCard
              icon={<History size={21} />}
              title="Solution History"
              text="Keep your solved questions organised so you can revisit difficult problems."
              to="/history"
            />

            <FeatureCard
              icon={<BarChart3 size={21} />}
              title="Track Your Progress"
              text="Understand your practice patterns and identify areas that need more attention."
              to="/progress"
            />

            <FeatureCard
              icon={<Trophy size={21} />}
              title="Learn From Mistakes"
              text="Turn every wrong attempt into a learning opportunity with clear explanations."
              to="/mistakes"
            />

          </div>

        </div>

      </section>


      {/* =====================================================
          HOW IT WORKS
      ===================================================== */}
      <section id="how-it-works" className="bg-slate-950">

        <div className="mx-auto max-w-7xl px-5 py-20 sm:px-8">

          <div className="max-w-2xl">

            <p className="text-xs font-extrabold uppercase tracking-[0.2em] text-indigo-400">
              Simple process
            </p>

            <h2 className="mt-3 text-3xl font-black tracking-tight text-white sm:text-4xl">
              From stuck to solved in three steps.
            </h2>

            <p className="mt-4 leading-7 text-slate-400">
              No complicated setup. Just bring the problem you're struggling
              with.
            </p>

          </div>


          <div className="mt-12 grid gap-6 md:grid-cols-3">

            <ProcessCard
              number="01"
              icon={<FileImage size={22} />}
              title="Ask your question"
              text="Type your question or upload an image of the problem you're stuck on."
            />

            <ProcessCard
              number="02"
              icon={<Brain size={22} />}
              title="AI analyses it"
              text="Arogya-AI understands the question, identifies the concept and builds the solution."
            />

            <ProcessCard
              number="03"
              icon={<GraduationCap size={22} />}
              title="Learn the solution"
              text="Follow every step, understand the concept and become confident solving similar problems."
            />

          </div>

        </div>

      </section>


      {/* =====================================================
          SOLVER CTA
      ===================================================== */}
      <section className="bg-white">

        <div className="mx-auto max-w-7xl px-5 py-20 sm:px-8">

          <div className="relative overflow-hidden rounded-[2rem] bg-indigo-600 px-7 py-12 sm:px-12 lg:px-16 lg:py-16">

            <div className="absolute -right-20 -top-20 h-72 w-72 rounded-full bg-white/10 blur-3xl" />
            <div className="absolute -bottom-20 -left-20 h-72 w-72 rounded-full bg-violet-400/20 blur-3xl" />

            <div className="relative flex flex-col justify-between gap-10 lg:flex-row lg:items-center">

              <div className="max-w-2xl">

                <div className="flex items-center gap-2 text-indigo-100">
                  <Sparkles size={17} />
                  <span className="text-xs font-bold uppercase tracking-[0.18em]">
                    Your AI study partner
                  </span>
                </div>

                <h2 className="mt-4 text-3xl font-black tracking-tight text-white sm:text-4xl">
                  Stuck on a difficult question?
                </h2>

                <p className="mt-4 max-w-xl leading-7 text-indigo-100">
                  Don't spend hours searching for the answer. Ask Arogya-AI
                  and understand the problem step by step.
                </p>

              </div>

              <button className="flex shrink-0 items-center justify-center gap-2 rounded-xl bg-white px-6 py-3.5 text-sm font-extrabold text-indigo-700 shadow-xl transition hover:-translate-y-0.5 hover:bg-indigo-50">
                Start Solving
                <ArrowRight size={17} />
              </button>

            </div>

          </div>

        </div>

      </section>


      {/* =====================================================
          FOOTER
      ===================================================== */}
      <footer id="about" className="border-t border-slate-200 bg-white">

        <div className="mx-auto max-w-7xl px-5 py-12 sm:px-8">

          <div className="grid gap-10 md:grid-cols-4">

            <div className="md:col-span-2">

              <div className="flex items-center gap-3">

                <div className="flex h-10 w-10 items-center justify-center rounded-xl bg-indigo-600 text-white">
                  <Brain size={20} />
                </div>

                <div>
                  <p className="font-extrabold">
                    Arogya<span className="text-indigo-600">-AI</span>
                  </p>
                  <p className="text-[9px] font-bold uppercase tracking-widest text-slate-400">
                    Learn • Solve • Master
                  </p>
                </div>

              </div>

              <p className="mt-5 max-w-md text-sm leading-6 text-slate-500">
                An AI-powered learning platform designed to help JEE and NEET
                aspirants understand complex problems through step-by-step
                explanations.
              </p>

            </div>


            <div>
              <p className="text-sm font-bold text-slate-900">
                Platform
              </p>

              <div className="mt-4 space-y-3 text-sm text-slate-500">
                <p>AI Solver</p>
                <p>Practice</p>
                <p>Subjects</p>
                <p>My Solutions</p>
              </div>
            </div>


            <div>
              <p className="text-sm font-bold text-slate-900">
                Exams
              </p>

              <div className="mt-4 space-y-3 text-sm text-slate-500">
                <p>JEE</p>
                <p>NEET</p>
                <p>Physics</p>
                <p>Chemistry</p>
              </div>
            </div>

          </div>


          <div className="mt-10 flex flex-col justify-between gap-3 border-t border-slate-100 pt-6 text-xs text-slate-400 sm:flex-row">
            <p>© 2026 Arogya-AI. All rights reserved.</p>
            <p>Built for the next generation of learners.</p>
          </div>

        </div>

      </footer>

    </div>
  );
}


/* =========================================================
   COMPONENTS
========================================================= */

function SolutionStep({ number, title, text }) {
  return (
    <div className="flex gap-3">

      <div className="flex h-6 w-6 shrink-0 items-center justify-center rounded-md bg-indigo-600 text-[9px] font-bold text-white">
        {number}
      </div>

      <div>
        <p className="text-xs font-bold text-slate-800">
          {title}
        </p>

        <p className="mt-1 text-[11px] leading-5 text-slate-500">
          {text}
        </p>
      </div>

    </div>
  );
}


function Stat({ value, label }) {
  return (
    <div className="px-5 py-7 text-center sm:py-8">
      <p className="text-2xl font-black tracking-tight text-slate-950">
        {value}
      </p>
      <p className="mt-1 text-xs font-medium text-slate-400">
        {label}
      </p>
    </div>
  );
}


function SubjectCard({ icon, title, exam, description }) {
  return (
    <div className="group rounded-2xl border border-slate-200 bg-white p-6 transition duration-300 hover:-translate-y-1 hover:border-indigo-200 hover:shadow-xl hover:shadow-slate-200/60">

      <div className="flex items-start justify-between">

        <div className="flex h-11 w-11 items-center justify-center rounded-xl bg-indigo-50 text-indigo-600 transition group-hover:bg-indigo-600 group-hover:text-white">
          {icon}
        </div>

        <span className="rounded-md bg-slate-100 px-2 py-1 text-[9px] font-bold text-slate-500">
          {exam}
        </span>

      </div>

      <h3 className="mt-5 text-base font-extrabold">
        {title}
      </h3>

      <p className="mt-2 text-sm leading-6 text-slate-500">
        {description}
      </p>

      <div className="mt-5 flex items-center gap-1 text-xs font-bold text-indigo-600">
        Explore
        <ArrowRight size={13} />
      </div>

    </div>
  );
}


function FeatureCard({ icon, title, text, to }) {
  return (
    <Link
      to={to}
      className="group block rounded-2xl border border-slate-200 bg-white p-6 transition duration-300 hover:-translate-y-1 hover:border-indigo-200 hover:shadow-xl hover:shadow-slate-200/50"
    >

      <div className="flex h-11 w-11 items-center justify-center rounded-xl bg-indigo-50 text-indigo-600 transition group-hover:bg-indigo-600 group-hover:text-white">
        {icon}
      </div>

      <h3 className="mt-5 text-base font-extrabold">
        {title}
      </h3>

      <p className="mt-2 text-sm leading-6 text-slate-500">
        {text}
      </p>

      <div className="mt-5 flex items-center gap-1 text-xs font-bold text-indigo-600">
        Open
        <ArrowRight size={13} className="transition group-hover:translate-x-1" />
      </div>

    </Link>
  );
}

function ProcessCard({ number, icon, title, text }) {
  return (
    <div className="relative rounded-2xl border border-slate-800 bg-slate-900 p-7">

      <div className="flex items-center justify-between">

        <div className="flex h-11 w-11 items-center justify-center rounded-xl bg-indigo-500/10 text-indigo-400">
          {icon}
        </div>

        <span className="text-3xl font-black text-slate-800">
          {number}
        </span>

      </div>

      <h3 className="mt-7 text-lg font-extrabold text-white">
        {title}
      </h3>

      <p className="mt-3 text-sm leading-6 text-slate-400">
        {text}
      </p>

    </div>
  );
}

export default Home;