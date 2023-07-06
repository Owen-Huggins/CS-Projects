
const { Client, GatewayIntentBits } = require('discord.js');
const { createReadStream } = require('fs');
const { createAudioResource, StreamType, joinVoiceChannel, createAudioPlayer, VoiceConnectionStatus } = require('@discordjs/voice');
//const ytdl = require("ytdl-core");

const KEYS = require('./keys.json');

const AUDIO1 = "whomp1.mp4";
const AUDIO2 = "whomp2.mp4";
const AUDIO3 = "whomp3.mp4";

const COMMAND_SPAM_CHANNEL_ID = "864298208867778560";
const WHOMP1BOT_ID = "1092558183085654111";

const makeClient = () => new Client({
	intents: [
		GatewayIntentBits.Guilds,
		GatewayIntentBits.GuildMessages,
		GatewayIntentBits.MessageContent,
		GatewayIntentBits.GuildMembers,
    GatewayIntentBits.GuildVoiceStates,
	],
});

const initVoice = (channel) => joinVoiceChannel({
  channelId: channel.id,
  guildId: channel.guild.id,
  adapterCreator: channel.guild.voiceAdapterCreator,
  selfDeaf: false
});

//const cl1 = makeClient();
const cl2 = makeClient();

const player = createAudioPlayer();



//cl1.once('ready', () => {
//  console.log(`Client 1: logged in as ${cl1.user.tag}!`);
//});

cl2.once('ready', () => {
  console.log(`Client 2: logged in as ${cl2.user.tag}!`);
});


cl2.on('messageCreate', async message => { //client 1 is 'master' client
  const SPAM_CHANNEL = await cl2.channels.cache.get(COMMAND_SPAM_CHANNEL_ID);
  if (message.channel === SPAM_CHANNEL && message.member.id === WHOMP1BOT_ID) { //confirmation from bot 1
    message.delete();

    const voiceChannel = message.member.voice.channel;

    if (voiceChannel) {

      const con1 = initVoice(voiceChannel);

      con1.on(VoiceConnectionStatus.Ready, async ()=> {
          const resource = createAudioResource(AUDIO2);
          con1.subscribe(player);
          
          player.play(resource);
          player.once('idle', async () => {
            SPAM_CHANNEL.send({content: "done"});
            con1.destroy();
          });
      });
    }
  }
});


//cl1.login('MTA5MjU1ODE4MzA4NTY1NDExMQ.Gz6Qao.dmqZMX3T5-qm4wqDyU_L-zxiBH9PcrFvxie7FY');
cl2.login(KEYS.key2);

//module.exports = { callSecondClientVoice };