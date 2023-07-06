
const { Client, GatewayIntentBits } = require('discord.js');
const { createReadStream } = require('fs');
const { createAudioResource, StreamType, joinVoiceChannel, createAudioPlayer, VoiceConnectionStatus } = require('@discordjs/voice');

const KEYS = require('./keys.json');

//const ytdl = require("ytdl-core");
//const { callSecondClientVoice } = require('./test2.js');
//import { callSecondClientVoice } from './test2.js';

const AUDIO1 = "whomp1.mp4";
const AUDIO2 = "whomp2.mp4";
const AUDIO3 = "whomp3.mp4";

const COMMAND_SPAM_CHANNEL_ID = "864298208867778560";
const WHOMP2BOT_ID = "1092647334837493800";

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

const cl1 = makeClient();
//const cl2 = makeClient();

const player = createAudioPlayer();

var con1 = null;


cl1.once('ready', () => {
  console.log(`Client 1: logged in as ${cl1.user.tag}!`);
});

cl1.on('messageCreate', async message => { //client 1 is 'master' client
  const SPAM_CHANNEL = await cl1.channels.cache.get(COMMAND_SPAM_CHANNEL_ID);
  if (message.content === '!whomp') {
    const voiceChannel = message.member.voice.channel;
    if (voiceChannel) {
      con1 = initVoice(voiceChannel);
      con1.on(VoiceConnectionStatus.Ready, async ()=> {
          const resource = createAudioResource(AUDIO1);
          con1.subscribe(player);
          
          player.play(resource);
          player.once('idle', async () => {
            //send confirmation
            SPAM_CHANNEL.send({content: "done"});
          });
      });
    }
  }
  if (message.channel === SPAM_CHANNEL && message.member.id === WHOMP2BOT_ID) { //check if bot2 sent confirmation
    message.delete();
    const resource2 = createAudioResource(AUDIO3);//response
    con1.subscribe(player);
        
    player.play(resource2);
    player.once('idle', async () => {
      con1.destroy();
      con1 = null;
    });
  }
});

cl1.login(KEYS.key1);
