import { Link } from "react-router-dom";
import {
  ArrowLeft,
  BarChart3,
  Target,
  Trophy,
  CheckCircle2,
  Clock3,
  TrendingUp,
} from "lucide-react";

function Progress() {
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

        {/* Title */}
        <div className="mb-8">
          <div className="mb-3 flex h-12 w-12 items-center justify-center rounded-xl bg-indigo-100 text-indigo-600">
            <BarChart3 size={25} />
          </div>

          <h2 className="text-3xl font-extrabold tracking-tight">
            Your Progress
          </h2>

          <p className="mt-2 max-w-2xl text-slate-500">
            Track your JEE & NEET preparation, understand your performance,
            and identify areas that need more attention.
          </p>
        </div>

        {/* Stats */}
        <div className="grid gap-5 md:grid-cols-2 lg:grid-cols-4">

          <div className="rounded-2xl border border-slate-200 bg-white p-6">
            <div className="flex items-center justify-between">
              <p className="text-sm font-semibold text-slate-500">
                Questions Solved
              </p>
              <CheckCircle2 className="text-indigo-600" size={21} />
            </div>

            <h3 className="mt-4 text-3xl font-extrabold">128</h3>
            <p className="mt-1 text-sm text-emerald-600">
              +18 this week
            </p>
          </div>

          <div className="rounded-2xl border border-slate-200 bg-white p-6">
            <div className="flex items-center justify-between">
              <p className="text-sm font-semibold text-slate-500">
                Accuracy
              </p>
              <Target className="text-indigo-600" size={21} />
            </div>

            <h3 className="mt-4 text-3xl font-extrabold">82%</h3>
            <p className="mt-1 text-sm text-emerald-600">
              Improving steadily
            </p>
          </div>

          <div className="rounded-2xl border border-slate-200 bg-white p-6">
            <div className="flex items-center justify-between">
              <p className="text-sm font-semibold text-slate-500">
                Study Time
              </p>
              <Clock3 className="text-indigo-600" size={21} />
            </div>

            <h3 className="mt-4 text-3xl font-extrabold">24h</h3>
            <p className="mt-1 text-sm text-slate-500">
              This month
            </p>
          </div>

          <div className="rounded-2xl border border-slate-200 bg-white p-6">
            <div className="flex items-center justify-between">
              <p className="text-sm font-semibold text-slate-500">
                Current Streak
              </p>
              <Trophy className="text-indigo-600" size={21} />
            </div>

            <h3 className="mt-4 text-3xl font-extrabold">7 days</h3>
            <p className="mt-1 text-sm text-emerald-600">
              Keep it going!
            </p>
          </div>

        </div>

        {/* Progress Section */}
        <div className="mt-8 grid gap-6 lg:grid-cols-2">

          {/* Subject Progress */}
          <section className="rounded-2xl border border-slate-200 bg-white p-7">

            <div className="flex items-center justify-between">
              <div>
                <h3 className="text-lg font-extrabold">
                  Subject Progress
                </h3>
                <p className="mt-1 text-sm text-slate-500">
                  Your current performance by subject
                </p>
              </div>

              <TrendingUp className="text-indigo-600" size={22} />
            </div>

            <div className="mt-7 space-y-6">

              <ProgressBar
                subject="Physics"
                percentage={78}
              />

              <ProgressBar
                subject="Chemistry"
                percentage={84}
              />

              <ProgressBar
                subject="Mathematics"
                percentage={72}
              />

              <ProgressBar
                subject="Biology"
                percentage={89}
              />

            </div>

          </section>

          {/* Weekly Activity */}
          <section className="rounded-2xl border border-slate-200 bg-white p-7">

            <h3 className="text-lg font-extrabold">
              Weekly Activity
            </h3>

            <p className="mt-1 text-sm text-slate-500">
              Questions solved during the last 7 days
            </p>

            <div className="mt-8 flex h-48 items-end justify-between gap-3">

              <ActivityBar day="Mon" value="55%" />
              <ActivityBar day="Tue" value="70%" />
              <ActivityBar day="Wed" value="45%" />
              <ActivityBar day="Thu" value="85%" />
              <ActivityBar day="Fri" value="65%" />
              <ActivityBar day="Sat" value="95%" />
              <ActivityBar day="Sun" value="75%" />

            </div>

          </section>

        </div>

        {/* Bottom CTA */}
        <div className="mt-8 rounded-2xl bg-indigo-600 p-7 text-white shadow-xl shadow-indigo-200">

          <div className="flex flex-col items-start justify-between gap-5 md:flex-row md:items-center">

            <div>
              <h3 className="text-xl font-extrabold">
                Ready to improve your score?
              </h3>

              <p className="mt-1 text-sm text-indigo-100">
                Solve more problems and strengthen your concepts with
                step-by-step AI explanations.
              </p>
            </div>

            <Link
              to="/ai-assistant"
              className="flex items-center gap-2 rounded-xl bg-white px-5 py-3 text-sm font-bold text-indigo-600 transition hover:bg-indigo-50"
            >
              Start Solving
              <TrendingUp size={17} />
            </Link>

          </div>

        </div>

      </main>
    </div>
  );
}


/* Progress Bar */
function ProgressBar({ subject, percentage }) {
  return (
    <div>
      <div className="mb-2 flex items-center justify-between">
        <span className="text-sm font-bold text-slate-700">
          {subject}
        </span>

        <span className="text-sm font-bold text-indigo-600">
          {percentage}%
        </span>
      </div>

      <div className="h-2.5 overflow-hidden rounded-full bg-slate-100">
        <div
          className="h-full rounded-full bg-indigo-600"
          style={{ width: `${percentage}%` }}
        />
      </div>
    </div>
  );
}


/* Activity Bar */
function ActivityBar({ day, value }) {
  return (
    <div className="flex h-full flex-1 flex-col items-center justify-end gap-2">

      <div className="flex h-full w-full items-end">
        <div
          className="w-full rounded-t-lg bg-indigo-500 transition hover:bg-indigo-600"
          style={{ height: value }}
        />
      </div>

      <span className="text-xs font-semibold text-slate-400">
        {day}
      </span>

    </div>
  );
}

export default Progress;