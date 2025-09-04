# Rakefile

task :clean do
  # Add commands to clean your project files
  sh "rm -rf build/*" # Example: removes files from a 'build' directory
  puts "Cleaned build directory."
end

task :package do
  # Add commands to package your application
  sh "jar -cvf crypto.jar ." # Example: creates a JAR file
  puts "Packaged application into crypto.jar."
end

task :default => [:clean, :package]
