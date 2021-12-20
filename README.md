# File-Tree-Extractor
This is a Java Script which takes a folder with several nested directories inside and extracts them into one big folder. I created this script to aid in my Plex Library transcoding, as HandBrake was unable to parse through my Folder-organized Library of movies. However, it can be used for anything that requires comverting trees of folders into one big folder

## How to use:

**This tutorial assumes you know how file paths work. If you don't, wait for me to make a GUI version of this app :)**

1. First off, make sure you have some way of running Java code. I personally like to use VSCode with the Java extension, along with the OpenJDK JVM. However that portion is entirely up to you. You could be using Eclipse, IntelliJ IDEA, or your own IDE which you developped to defy this list. As long as you can exectute Java files, you're all set!

2. When you first run this program, I'd suggest reading the disclaimer, since it's pretty important. After all, I'm not a professional. I made this script in 15 minutes because I couldn't be bothered looking for software online that did what I needed.

3. You'll then be asked to enter the file path for the source directory. This is the folder with all the folders inside with elements you'd like to extract. For example, if my source directory was

`C:\School\Code`

Then I'd enter that

4. After inputting that, you'll then be asked for the output directory. This is the folder where all the files will be extracted to. If you point it to a folder that doesn't exist, it'll ask if you'd like to create said folder, or re-enter a path that exists

5. After that, the script is off! The script is not *yet* multithreaded, so the script may take some time to run. If it detects any files with the same name, it will alert you and ask you to either rename or overwrite that file. 

## TODO:
- Add MultiThreading for increased performance
- Continue testing and ensure no bugs are present
- Add a GUI for better UX
- Fix whatevers broken? I guess?



**Disclaimer: No warranties accompany this script, whether stated explicitly or implicitly. Usage of this product is at the user's own risk. The owner does not provide supervision and cannot be held liable for any damage caused. Through the utilization of this script, you acknowledge and accept the inherent risks posed by a product composed by a 17-year-old in 15 minutes.**

Disclaimer by @unstructureddata 
