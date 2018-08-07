# Wholesomebot
WholesomeBot is a discord bot designed to spread happiness and wholesomeness, and is continually being updated and added to!
[Click Here](https://github.com/basion96/Wholesomebot/releases/download/v1.2/Wholesomebot_Full.zip) to download everything you need for Wholesomebot

## Table of Contents
* [Commands](#commands)
* [Non-command things](#other-non-command-things)
* [Planned features](#planned-features)
* [Pictures](#pictures)
* [Wholesome messages](#wholesome-messages)
* [Daily messages](#daily-messages)
* [Setting up Wholesomebot](#setting-up-wholesomebot)

## Commands
These are all the current commands available for wholesomebot, the default prefix is ! but can be changed to whatever you'd like.

|Command [args]|Description|
| --- | --- |
|help|Displays all commands and what they do.|
|Choose things \| to \| choose | wholeosmebot will randomly choose one of the options you provide split using \| eg. !choose yes \| no \| maybe.|
|compliment|Sends a compliment to the user.|
|cheermeup|Sends a message to try help cheer up the user.|
|quote|Sends a random inspirational quote.|
|recipe|Displays all the recipe commands and descriptions that are in the recipe.xml.|
|wholesomeimg|Sends a wholesome image (make sure you add pictures in the resources/pictures file).|
|wholesome|Sends a random wholesome message.|
|nerdstats|Displays a bunch of info about wholesomebot and the system its running on.|

## Other Non-Command Things
Wholesomebot also responds to certain messages, such as "how are you today wholesomebot". Can you discover all the different responses?

## Pictures
If you want the !wholesomeimg command to work, you're going to have provide your own wholesome memes. I would provide them for you, but yeahhhh the file size would be big haha.

Here's a [google drive link](https://drive.google.com/drive/folders/10fO4BGfbTUjsFNT9e4yhiMOU5j_ldUGi?usp=sharing) to a bunch of the ones i use :).
(Don't blame me if i've put duplicates up on there)
## Messages folder
Feel free to any messages and stuff to any of these files, the more you have the less chance of Wholesomebot saying the same thing twice haha

## Daily Messages
Wholesomebot sends out daily wholesome and good morning messages, provided you dont disable is haha.

#### Daily wholesome message:
Wholesomebot will send a random wholesome message at the time specified once per day

#### Daily good morning message:
Wholesomebot will send a good morning message to 1 user each day. A user will be only mentioned once per cycle of all the users in the guild (So everyone gets a turn).

## Setting Up Wholesomebot
Wholesomebot is pretty easy to setup, you simply need to download the files,
put in the required info into the config file, and BAM! you're done!
### Downloading & Installing
Ok to start off, please make sure you have [java](http://javadl.oracle.com/webapps/download/AutoDL?BundleId=233172_512cd62ec5174c3487ac17c61aaa89e8) installed.

Now that's sorted, what you're going to want to do is actually download wholesomebot [(Here's a link for you)](https://github.com/basion96/Wholesomebot/releases/download/v1.2/Wholesomebot_Full.zip).

Now that you have that zip file downloaded, what you're going to want to do is extract those files to where ever you want to run wholesomebot from.
So you should have a folder with Wholesomebot.jar and and a folder called resources. Tada it's installed.

### Configuring Wholesomebot
Time to configure Wholesomebot!

First things first, make sure you've created a bot user for discord. Dont know how? [Well here's how!](#making-a-bot-user)

Now im gonna assume you've got yourself a bot, ok? Sweet!
 
#### The config file
make sure you put all your values after the equals sign (=), Eg. `token = abcdefghijklmnopqrstuvwxyz`

|Config Option|Description|
| --- | --- |
|token|Put your bots token here|
|wholesomeMessageTime|The time you want the daily wholesome message to be sent. Uses 24hr time.|
|morningMessageTime|The time you want the good morning message sent. Uses 24hr time.|
|prefix|Put what you want the prefix to be here, default is !|
|publicChannel|The channel ID of the channel you want to use for the daily messages. (Don't know hot to get the channel ID? [click here!](#channel-id))|
|welcomeChannel|The channel you want to use for welcoming new members to the channel (can just put the same channel id as public channel here if you want)|
|adminRole|The name of the role that admins have, default is admin.|``````````````````
(NOTE: Don't want daily message? just ``put a number in greater than 24, like 25).
You are done configuring the bot, awesome! now all you have to do is run the bot!

#### Running the bot
To run the bot, you could just double click the jar file to get it running.

OR

Open command prompt/powershell/terminal, or whatever, navigate to the directory that the jar is in and type java -jar Wholesomebot.jar

Now Wholesomebot should run perfectly!(Hopefully, i'm not the best at giving instructions lol). 

#### Making a bot user
Head over to the [Discord developers](https://discordapp.com/developers/docs/intro) page, and click on My Apps.

Now click on "New App" and give your bot a name and optionally a description and picture. Once you've dont that, you can click on "Create App".

Once you've done that, scroll down the page a bit and you'll see the option to create a bot user, plz do that.

Success! you've now got yourself a sexy bot!

#### Channel ID
kk so, getting the channel id is quite simple. Go to User Settings -> Appearance, and then turn on developer mode.

Once developer mode is turned on, right click on the channel you want and click "copy ID". And you're Done!

## Libraries Used
[Java Discord API](https://github.com/DV8FromTheWorld/JDA)

## Authors
* Alexandra: Idea & design
* Jason: Programming & some design

