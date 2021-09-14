# AeroSense

#### Description
Radar server backend interface code

#### Software Architecture
Software architecture description

#### Installation

1.  Install jdk 1.8.2
2.  Install tomcat 8
3.  Install java development tools idea or myeclipse
4.  Install spring web related jar package 5.3.x version or install maven 3.6.3
5.  Configure the environment tomcat maven environment

#### Instructions

1.  Import the code into the development tool to run
2.  Start the radar for network distribution
3.  Conduct a radar test

#### Contribution

1.  Fork the repository
2.  Create Feat_xxx branch
3.  Commit your code
4.  Create Pull Request

#### AeroSense Instructions
1. Input the code into the development tool to run, and startup the server.
2. Start the sensor to configure the network, and point the destination IP address and port of AeroSense to the server. For the network configuration tutorial, refer to " AeroSense Assure User Development Guide Manual"
3. After configured successfully, you can print KeepAlive and other requests on the console.

#### Skill
If you need to test KeepAlive messages multiple times, you can restart AeroSense repeatedly and power off. AeroSense will request the server immediately after power on.

#### FAQ
1. Using the AeroSenseTool tool, when the test server returns "OK" instead of the OK string, the Json is returned at this time, and the string should be returned.For modification, please refer to https://blog.csdn.net/baidu_27055141/ article/details/91544019
2. Return Response,remove AcceptCharset,and call setWriteAcceptCharset(false);
