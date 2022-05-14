const Discord = require('discord.js');
const client = new Discord.Client();

client.on('ready', () => {
  console.log(`Logged in as ${client.user.tag}!`);
});

client.on('message', msg => {
   var mention = msg.mentions.users.first();
   if (mention) {
     if (mention.id === "243531338190159872") {
       msg.channel.send("", {files:["https://i.kym-cdn.com/photos/images/newsfeed/001/958/720/4b2.jpg"]});
     }
   }
});

client.login('ODE5NDgyNDUyNTE4NTAyNDAw.YEnQgQ.gR6bm0gI51tSw0XLvYarbwbJhRI');
