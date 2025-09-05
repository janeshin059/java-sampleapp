# Rakefile

# The path to your source code directory.
SOURCE_DIR = "src"

# The path to your build output directory.
BUILD_DIR = "build"

# The path to your compiled classes directory.
CLASSES_DIR = "#{BUILD_DIR}/classes"

# The name of the final JAR file.
JAR_FILE = "TarGzExtractor.jar"

# --- Rake Tasks ---

desc "Cleans the build directory."
task :clean do
  sh "rm -rf #{BUILD_DIR}"
  puts "Cleaned build directory."
end

desc "Compiles Java source files."
task :compile do
  # Create the output directory for compiled classes.
  classpath = FileList["lib/*.jar"].join(':')
  sh "mkdir -p #{CLASSES_DIR}"

  
  # Compile all .java files from the source directory and place them in the classes directory.
  sh "javac -d #{CLASSES_DIR} -cp #{classpath} TarGzExtractor.java"
  puts "Compiled Java source code."
end

desc "Packages the compiled classes into a JAR file."
task :package => [:compile] do
  # Change directory to the compiled classes and create the JAR from its contents.
  sh "jar -cvf #{JAR_FILE} -C #{CLASSES_DIR} ."
  puts "Packaged application into #{JAR_FILE}."
end

desc "Runs all necessary tasks to build the application."
task :default => [:clean, :package]
