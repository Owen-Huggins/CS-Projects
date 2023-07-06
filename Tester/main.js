
const { Client, GatewayIntentBits } = require('discord.js');
const { createReadStream } = require('fs');
const { createAudioResource, StreamType, joinVoiceChannel, createAudioPlayer, VoiceConnectionStatus } = require('@discordjs/voice');
//const ytdl = require("ytdl-core");

const client = new Client({
	intents: [
		GatewayIntentBits.Guilds,
		GatewayIntentBits.GuildMessages,
		GatewayIntentBits.MessageContent,
		GatewayIntentBits.GuildMembers,
    GatewayIntentBits.GuildVoiceStates,
	],
});
const player = createAudioPlayer();


client.once('ready', () => {
  console.log(`Logged in as ${client.user.tag}!`);
});

client.on('messageCreate', async message => {
  if (message.content === 't') {

    const voiceChannel = message.member.voice.channel;

    if (voiceChannel) {
      const connection = joinVoiceChannel({
        channelId: voiceChannel.id,
        guildId: voiceChannel.guild.id,
        adapterCreator: voiceChannel.guild.voiceAdapterCreator,
        selfDeaf: false
      });

      connection.on(VoiceConnectionStatus.Ready, async ()=> {
          const resource = createAudioResource('WhompWhomp.mp4');
        
          connection.subscribe(player);
          
          player.play(resource);
          player.once('idle', () => {
            connection.destroy();
          });
      });
    }
  }
});


client.login('MTA5MjU1ODE4MzA4NTY1NDExMQ.Gz6Qao.dmqZMX3T5-qm4wqDyU_L-zxiBH9PcrFvxie7FY');