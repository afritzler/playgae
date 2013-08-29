playgae
=======

Running Play! Framework (1.2.5) on the Google App Engine

Changelog
---------

_Version 1.0_

* Application skeleton generated with version 1.2.5 of the Play! Framework
* Siena modul version 2.0.6
* GAE modul version 1.6.0
* jQuery 1.10.2
* Twitter Bootstrap 3.0.0

Getting Started
---------------

0. Prerequisite: You have downloaded and unzipped the latest Google App Engine Java SDK (https://developers.google.com/appengine/downloads#Google_App_Engine_SDK_for_Java)

1. To get you started you first need to download the latest version Play! Framework (1.2.5). http://www.playframework.com/download

2. The installation is pretty straight forward. Just unzip and add play to your path

      export PATH=$PATH:/PLAYINSTALLDIR/play-1.2.5

3. Install GAE module (latest is 1.6.0)

      play install gae

4. Install siena module (latest is 2.0.6)

      play install siena

5. Edit /YOURAPP/conf/dependencies.yml

      require: 
          – play 
          – play -> gae 1.6.0
          – play -> siena 2.0.6

6. Add to conf/application.conf

      # —- Google app engine module —- 
      
      module.gae=${play.path}/modules/gae-1.6.0 
      
      # —- Siena module —- 
      
      module.siena=${play.path}/modules/siena-2.0.6

7. Now you should be able to run your application on your local development environment
      
      play run playgae

8. Play will generate a war folder within your applications root directory. Edit /war/WEB-INF/appengine-web.xml and enter your App Engine appId.

9. Last but not least we want to get our application running on the real thing, To deploy your application to the App Engine:

      play war playgae -o playgae-war
      
      /PATH-TO-APP-ENGINE-SDK/bin/appcfg.sh update playgae-war/
    
  Once the deployment has finished, you can access your application via http://appid.appspot.com

Demo
----

A demo deployment can be found here: http://play1gae.appspot.com/

Have fun with the Play! Framework on Google's App Engine!
