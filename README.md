**HR Rotation Application**

The application is intended for internal use only, accessible to users inside the corporate VPN.

The deployment address should be:
http://resourcing-appassingments-app.uk.capgemini.com:8080

_(the typo is believed to have been unintentional, but since the address has been widely published, its not likely to change.)_

The application has two accessible pages:
1. upload-available-roles.html

   This page should be used by appropriate personell to upload (on a frequent basis) an Excel spreadsheet containing the available roles. 

2. index.html

   This page displays the available roles, and should be usable on modern browsers.(Chrome 24+, IE8+ at a minimum)
   
**Application Technology**

The application is a SpringBoot based self-contained server which can be deployed on any system having a suitable Java 8 installaion.

Each of the two UI pages are completely independent of each other.

The index.html is a JavaScript-driven one-page application which relies on the back-end code for a single web-service, which provided a json-format list of available roles. The page displays a series of bootstrap formatted cards (one for each available role, displayed in a horizontally-scrollable window), each of which when clicked displays an overlay with further details of the role.

**Tech Stack**

*Back-End*

  Java 8
  SpringBoot
  JSON
  Web Services (JAX-B)
  
*Front-End*

  JavaScript
  Bootstrap
  HTML
  CSS
  
*Build Tools*

   Maven
   
**Repository**

The code is hosted at:
{Insert repo address}       
  
