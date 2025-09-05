# Rakefile

task :clean do
  # Add commands to clean your project files
  sh "rm -rf build/*" # Example: removes files from a 'build' directory
  puts "Cleaned build directory."
end

task :package do
  # Add commands to package your application
  sh "jar -cvf TarGzExtractor.jar ." # Example: creates a JAR file
  puts "Packaged application into TarGzExtractor.jar."
end

task :default => [:clean, :package]
