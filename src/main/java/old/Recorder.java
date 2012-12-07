/**
 * 
 */
package old;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 * this class demostrates recording from the microphone
 * the majority of this code was written by me with help
 * take from:
 * 
 * http://www.java-tips.org/java-se-tips/javax.sound/capturing-audio-with-java-sound-api.html
 * 
 * @author Tom
 *
 */
public class Recorder extends Thread {
	private TargetDataLine line;
	private AudioFormat format;
	private boolean trigger = true;
	private byte buffer[];
	private ByteArrayOutputStream bos;
	private String fileName;

	/**
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	*/
	
	public Recorder(String fileName) throws LineUnavailableException{
		/*
		 * First set the Audio format to record in this
		 * includes setting the encoding which will be PCM
		 * at an 8kz sample rate
		 * 
		 */
		this.fileName = fileName;
		float sampleRate = 16000;
		int sampleSizeBits = 16;
		int channel = 1;
		boolean signed = true;
		boolean bigEndian = true;
		
		format = new AudioFormat(sampleRate,sampleSizeBits,channel,signed,bigEndian);
		//then need to get data line which we can get our recording from
		DataLine.Info info = new DataLine.Info(TargetDataLine.class,format);
		//info object represents the data line were looking for
		
		line = (TargetDataLine) AudioSystem.getLine(info);
		//line acts as a kind of AudioInputStream
			
	}
	
	public void setTrigger(boolean trigger){
		this.trigger = trigger;
	}
	
	public void run(){
		try {
			startRecord();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startRecord() throws LineUnavailableException, IOException{
		//read sound into byte array
		line.open(format);
		line.start();
		
		int bufferSize = (int) format.getSampleRate() * format.getFrameSize();//indicates size of array
		buffer = new byte[bufferSize];
		 bos = new ByteArrayOutputStream();
		
		while(trigger){
			//bos writes to the array
			int count = line.read(buffer, 0, buffer.length);
			if(count >0){
				bos.write(buffer, 0, count);
				
			}
		}
		System.out.println("Closeing stream");
		bos.close();
		saveData();
	}

	public void saveData() throws IOException {
		
		AudioInputStream out = new AudioInputStream(new ByteArrayInputStream(bos.toByteArray()),format, bos.toByteArray().length);
		System.out.println("Saving...");
		AudioSystem.write(out, AudioFileFormat.Type.WAVE, new File(fileName));
		//FileOutputStream fos = new FileOutputStream(new File("recording.wav"));
		//System.out.println("Saving...");
		//fos.write(buffer, 0, buffer.length);
		System.out.println("Saved");
		
	}

}
