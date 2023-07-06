const Discord = require('discord.js');

const client = new Discord.Client({ intents: [
  Discord.GatewayIntentBits.Guilds,
  Discord.GatewayIntentBits.GuildMessages,
  Discord.GatewayIntentBits.GuildVoiceStates
]})

client.on('ready', () => {
  console.log(`Logged in as ${client.user.tag}!`);
});

client.on('message',  message => {
  if (message.content.startsWith("test")) {
    message.reply("testing");
    console.log('test');
    // Checking if the message author is in a voice channel.
    if (!message.member.voice.channel) return message.reply("You must be in a voice channel.");
    // Checking if the bot is in a voice channel.
    if (message.guild.me.voice.channel) return message.reply("I'm already playing.");

    // Joining the channel and creating a VoiceConnection.
    message.member.voice.channel.join().then(VoiceConnection => {
        // Playing the music, and, on finish, disconnecting the bot.
        VoiceConnection.play("./Whomp.mp3").on("finish", () => VoiceConnection.disconnect());
        message.reply("Playing...");
    }).catch(e => console.log(e))
};
});


client.login('ODE5NDgyNDUyNTE4NTAyNDAw.YEnQgQ.gR6bm0gI51tSw0XLvYarbwbJhRI');
