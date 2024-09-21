import Image from "next/image";
import Link from 'next/link';

export default function Home() {
  function CardLink({ href, title, description }: { href: string, title: string, description: string }) {
    return (
      <a
        href={href}
      >
        <h2 className="mb-3 text-2xl font-semibold">
          {title}{" "}
          <span className="inline-block transition-transform group-hover:translate-x-1 motion-reduce:transform-none">
            -&gt;
          </span>
        </h2>
        <p className="m-0 max-w-[30ch] text-sm opacity-50">
          {description}
        </p>
      </a>
    );
  }

  return (
    <main className="flex flex-col items-center justify-between min-h-screen bg-gradient-to-r from-black-900 to-black-90">


      <div className="relative z-[-1] flex place-items-center p-6 lg:p-24 before:absolute before:h-[200px] before:w-[200px] before:-translate-x-1/2 before:rounded-full before:bg-gradient-radial before:from-white before:to-transparent before:blur-2xl before:content-[''] after:absolute after:-z-20 after:h-[120px] after:w-[120px] after:translate-x-1/3 after:bg-gradient-conic after:from-sky-200 after:via-blue-200 after:blur-2xl after:content-[''] before:dark:bg-gradient-to-br before:dark:from-transparent before:dark:to-blue-700 before:dark:opacity-10 after:dark:from-sky-900 after:dark:via-[#0141ff] after:dark:opacity-40 sm:before:w-[300px] sm:after:w-[180px]">
        <Image
          className="relative dark:drop-shadow-[0_0_0.3rem_#ffffff70] dark"
          src="/coding2.svg"
          alt="coding"
          width={200}
          height={200}
          priority
        />
      </div>
      <div>
        <p className="px-4 w-full text-center border-b border-gray-300 from-zinc-200 pb-6 pt-8 backdrop-blur-2xl dark:border-neutral-800 dark:bg-zinc-800/30 dark:from-inherit lg:static lg:w-auto lg:rounded-xl lg:border lg:bg-gray-200 lg:p-4 lg:dark:bg-zinc-800/30">
          Welcome to Our Coding Classes! We teach coding to kids aged 9 to 15 in a fun and engaging way.
        </p>
      </div>
      <section className="mb-32 grid text-center lg:mb-0 lg:w-full lg:max-w-5xl lg:grid-cols-4 lg:text-left p-6 lg:p-24 gap-4">
        <CardLink href="#coding-adventure" title="Join our Coding Adventure!" description="Let your child explore the exciting world of coding with our interactive classes!" />
        <CardLink href="#curriculum" title="Curriculum" description="Our comprehensive coding curriculum covers a wide range of topics, ensuring your child develops a strong foundation in computer science." />
        <CardLink href="#fun-activities" title="Filled with Fun Activities!" description="From coding games to creative projects, there's something for every child to enjoy!" />
        <CardLink href="#start-coding" title="Start Coding Today!" description="Give your child a head start in technology with our coding classes!" />
      </section>

      <section id="coding-adventure" className="w-full max-w-5xl p-6 lg:p-24 min-h-screen flex items-center justify-center">
        <div className="grid grid-cols-1 md:grid-cols-2 gap-8 items-center">
          <Image
            src="/coding.svg"
            alt="Coding Adventure"
            width={300}
            height={300}
            priority
          />
          <div>
            <h2 className="text-3xl font-bold mb-6">Join our Coding Adventure!</h2>
            <ul className="list-disc pl-5 space-y-2">
              <li>Engaging and interactive classes.</li>
              <li>Hands-on projects and fun activities.</li>
              <li>Introduction to basic Python concepts.</li>
              <li>Control flow, data structures, functions.</li>
              <li>Create a simple text-based game as a final project.</li>
            </ul>
          </div>
        </div>
      </section>

      <section id="curriculum" className="w-full max-w-5xl p-6 lg:p-24 min-h-screen flex flex-col justify-center">
        <h2 className="text-3xl font-bold mb-6 text-center">Curriculum</h2>
        <p className="mb-6 text-center">
          Our comprehensive coding curriculum covers a wide range of topics, ensuring your child develops a strong foundation in computer science.
        </p>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
          <div className="p-6 border rounded-lg shadow-md hover:shadow-lg transition-shadow bg-primary-foreground">
            <h3 className="text-xl font-semibold mb-2">Fundamentals of Coding</h3>
            <p>Introduction to coding principles and basic concepts.</p>
          </div>
          <div className="p-6 border rounded-lg shadow-md hover:shadow-lg transition-shadow bg-primary-foreground">
            <h3 className="text-xl font-semibold mb-2">Problem Solving</h3>
            <p>Develop problem-solving skills through coding challenges and projects.</p>
          </div>
          <div className="p-6 border rounded-lg shadow-md hover:shadow-lg transition-shadow bg-primary-foreground">
            <h3 className="text-xl font-semibold mb-2">Advanced Topics</h3>
            <p>Introduction to more complex programming concepts and techniques.</p>
          </div>
        </div>
      </section>

      <section id="fun-activities" className="w-full max-w-5xl p-6 lg:p-24 min-h-screen flex flex-col justify-center">
        <h2 className="text-3xl font-bold mb-6">Filled with Fun Activities!</h2>
        <div className="space-y-12">
          <div className="flex flex-col md:flex-row items-center gap-8">
            <Image
              src="/draco.svg"
              alt="Dragon Game"
              width={180}
              height={180}
              priority
            />
            <div>
              <h3 className="text-xl font-semibold mb-2">Dragon Game</h3>
              <p>An adventurous journey through caves of uncertainty—flip a coin with your choice; enter a treasure cave for victory, or dare the dragon cave for defeat.</p>
            </div>
          </div>
          <div className="flex flex-col md:flex-row items-center gap-8">
            <Image
              src="/space.svg"
              alt="Deep Thought"
              width={180}
              height={180}
              priority
            />
            <div>
              <h3 className="text-xl font-semibold mb-2">Great Question of Life</h3>
              <p>A cosmic quest where you&apos;re asked the ultimate question—input 42, forty-two, or forty two, and get a mystical &quot;Yes&quot;; say anything else, and receive a cosmic &quot;No.&quot;</p>
            </div>
          </div>
          <div className="flex flex-col md:flex-row items-center gap-8">
            <Image
              src="/coaster.svg"
              alt="Creative Projects"
              width={180}
              height={180}
              priority
            />
            <div>
              <h3 className="text-xl font-semibold mb-2">Rollercoaster Eligibility Checker</h3>
              <p>Find out if you are tall enough to ride the rollercoaster, and no standing on your toes is not allowed.</p>
            </div>
          </div>
        </div>
      </section>

      <section id="start-coding" className="w-full max-w-5xl p-6 lg:p-24 min-h-screen flex flex-col justify-center">
        <h2 className="text-3xl font-bold mb-6">Start Coding Today!</h2>
        <p className="mb-6">
          Give your child a head start in technology with our coding classes! Enroll now and watch as they develop skills that will serve them for a lifetime. Our classes are designed to be accessible and enjoyable for kids aged 9 to 15, making it easy for them to start their coding journey.
        </p>
        <div className="contact-info mb-6 bg-gray-800 p-4 rounded-lg shadow-md">
          <p className="text-lg font-semibold mb-2">Contact Information</p>
          <p className="text-sm">For more information and to enroll, please contact us at:</p>
          <div className="mt-2">
            <p className="text-sm">Email: <a href="mailto:learncodecraftacademy@gmail.com" className="text-blue-300 hover:text-blue-200 hover:underline">LearnCodecraftAcademy@gmail.com</a></p>
          </div>
          <Link href="/products">
        
    <button>Go to Payment Page</button>
          </Link>
      
        </div>
      </section>
    </main>
  );
}
