**Deployment**


1. Disable any existing Windows service for any previous version of this application.
2. Copy the 'resourcing-spreadsheet.xlsx' file from the previous installation's working directory into the directory containing the .jar file. 
3. This version is provided as an executable .jar. (**NB**. The previous application was a .war file. ) The code to run the application is ```java -jar <jarfile_name.jar>```
4. Install as a Windows service. (May require a wrapper ie Tanuki Service Wrapper).
5. Test
  
   Ensure both index.html and upload-available-roles.html are accessible
   If the file 'resourcing-spreadsheet.xlsx' is present in the working directory, ensure that the index.html page displays a list of available roles.
   If that file IS NOT present (for any reason) contact Claire Tuckwell (claire.tuckwell@capgemini.com) for a copy of the latest file to upload.
   
6. Assuming the tests pass, it should now be possible to remove the windows service for the previous version.
  
