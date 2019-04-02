package com.github.eostermueller.tjp2;

import java.util.concurrent.ThreadLocalRandom;

import com.github.eostermueller.tjp2.OldGenerationRepo.OldGenerationData;
import com.github.eostermueller.tjp2.perfkey.InvalidCode;
import com.github.eostermueller.tjp2.perfkey.PerformanceKey;


/**
 * @author erikostermueller
 *
 */
public class Config {
	
	public static final String DEFAULT_KEY = "X0,J100,K100,L0,Q0,S0,T0,A0,B1024,C0,D60000";

	public static Config SINGLETON = new Config();

	private  int currentLogLevel = 0;
	private  int xpathImplementation = 0; 
	private  int xsltImplementation = 0; 
	private  int randomIntegerImplementation = 0; 
	private  int processingItems = 100;
	private  int processingIterations = 100; 
	private  int fixedDelayMilliseconds = 0; 
	private  boolean fileCacheEnabled = false;
	private  boolean synchronizedSleepEnabled = false;
	private  boolean uuidIsOptimized = false; 
	private int oldGenMinExpirationMs = 0; 
	private int oldGenMaxExpirationMs = 60000; //set expirations time stamps that are System.currentTimeMillis() + random value, with this variable as the max.
	private int oldGenMaxBytes = 1024; //at most, add this many bytes to the old gen repository.
	private int oldGenRequestCountThresholdForPruning = 0;
	
	private IntegerChangeListener oldGenRequestCountThresholdForPruning_changeListener;

	/**
	 * Private ctor helps make this a singleton;
	 */
	public Config() { 
		
		
	}
	public int getCurrentLogLevel() {
		return currentLogLevel;
	}
	public void setCurrentLogLevel(Integer val) {
		if (val != null) {
			this.currentLogLevel = val;
			this.logAlways("CurrentLogLevel set to [" + this.currentLogLevel + "]");
		}
	}
	public int getXPathImplementation() {
		return xpathImplementation;
	}
	public void setXPathImplementation(Integer val) {
		if (val!=null) {
			this.xpathImplementation = val;
			this.logAlways("XPathImplementation set to [" + this.xpathImplementation + "]");
		}
	}
	
	public int getXsltImplementation() {
		return xsltImplementation;
	}
	public void setXsltImplementation(Integer val) {
		if (val!=null) {
			this.xsltImplementation = val;
			this.logAlways("XsltImplementation set to [" + this.xsltImplementation + "]");
		}
	}
	public boolean isUuidOptimized() {
		return uuidIsOptimized;
	}
	public void setUUIDIsOptimized(Boolean val) {
		if (val != null) {
			this.uuidIsOptimized = val;
			this.logAlways("UUIDIsOptimized set to [" + this.uuidIsOptimized + "]");
		}
	}
	public boolean isSleepSynchronized() {
            return synchronizedSleepEnabled;
        }
        public void setSynchronizedSleep(Boolean val) {
 		if (val != null) {
			this.synchronizedSleepEnabled = val;
			this.logAlways("isSleepSynchronized set to [" + this.synchronizedSleepEnabled + "]");
		}
        }

	public int getProcessingItems() {
		return processingItems;
	}
	public void setProcessingItems(Integer val) {
		if (val != null) {
			this.processingItems = val;
			this.logAlways("ProcessingItems set to [" + this.processingItems + "]");
		}
	}
	public int getProcessingIterations() {
		return processingIterations;
	}
	public int getFixedDelayMilliseconds() {
		return this.fixedDelayMilliseconds;
	}
	public void setFixedDelayMilliseconds(Integer val) {
		if (val != null) {
			this.fixedDelayMilliseconds = val;
			this.logAlways("FixedDelayMilliseconds set to [" + this.fixedDelayMilliseconds + "]");
		}
	}
	public void setProcessingIterations(Integer val) {
		if (val != null) {
			this.processingIterations = val;
			this.logAlways("ProcessingIterations set to [" + this.processingIterations + "]");
		}
	}
	public int getRandomIntegerImplementation() {
		return randomIntegerImplementation;
	}
	public void setRandomIntegerImplementation(Integer val) {
		if (val != null) {
			this.randomIntegerImplementation = val;
			this.logAlways("RandomIntegerImplementation set to [" + this.randomIntegerImplementation + "]");
		}
	}
	public boolean isFileCacheEnabled() {
		return fileCacheEnabled;
	}
	public void setFileCacheEnabled(Boolean val) {
		if (val != null) {
			this.fileCacheEnabled = val;
			this.logAlways("FileCacheEnabled set to [" + this.fileCacheEnabled + "]");
		}
	}
	private void logAlways(String msg) {
		Controller.logAlways(msg);
	}
	public String toXmlString() throws InvalidCode {
    	StringBuilder sb = new StringBuilder();
    	sb.append("<config>");
    	sb.append("\n    <logLevel>").append(getCurrentLogLevel() ).append("    </logLevel>");
    	sb.append("\n    <fileCache>").append(isFileCacheEnabled() ).append("    </fileCache>");
    	sb.append("\n    <syncSleep>").append(isSleepSynchronized() ).append("    </syncSleep>");
    	sb.append("\n    <xpathImplementation>").append(this.getXPathImplementation() ).append("    </xpathImplementation>");
    	sb.append("\n    <xsltImplementation>").append(this.getXsltImplementation() ).append("    </xsltImplementation>");
    	sb.append("\n    <uuidIsOptimized>").append(this.isUuidOptimized() ).append("    </uuidIsOptimized>");
    	sb.append("\n    <randomIntegerImplementation>").append(this.getRandomIntegerImplementation() ).append("    </randomIntegerImplementation>");
    	sb.append("\n    <processingItems>").append(this.getProcessingItems() ).append("    </processingItems>");
    	sb.append("\n    <processingIterations>").append(this.getProcessingIterations() ).append("    </processingIterations>");
    	sb.append("\n    <fixedDelayMilliseconds>").append(this.getFixedDelayMilliseconds() ).append("    </fixedDelayMilliseconds>");
    	sb.append("\n    <oldGenMinExpirationMs>").append(this.getOldGenMinExpirationMs() ).append("    </oldGenMinExpirationMs>");
    	sb.append("\n    <oldGenMaxExpirationMs>").append(this.getOldGenMaxExpirationMs() ).append("    </oldGenMaxExpirationMs>");
    	sb.append("\n    <oldGenMaxBytes>").append(this.getOldGenMaxBytes() ).append("    </oldGenMaxBytes>");
    	sb.append("\n    <oldGenRequestCountThresholdForPruning>").append( this.getOldGenRequestCountThresholdForPruning() ).append("    </oldGenRequestCountThresholdForPruning>");
    	
    	sb.append("\n    <perfKey>").append( new PerformanceKey(this).getKey() ).append("    </perfKey>");
   		
    	
    	sb.append("\n</config>");
		return sb.toString();
	}
	public int getOldGenMaxExpirationMs() {
		return this.oldGenMaxExpirationMs;
	}
	public void setOldGenMaxExpirationMs(Integer val) {
		if (val != null) {
			this.oldGenMaxExpirationMs = val;
			this.logAlways("oldGenMaxExpirationMs set to [" + this.oldGenMaxExpirationMs + "]");
		}
	}
	public int getOldGenMaxBytes() {
		return oldGenMaxBytes;
	}
	public void setOldGenMaxBytes(Integer val) {
		
		if (val != null) {
			this.oldGenMaxBytes = val;
			this.logAlways("oldGenMaxBytes set to [" + this.oldGenMaxBytes + "]");
		}
	}
	
	public int getOldGenRequestCountThresholdForPruning() {
		return oldGenRequestCountThresholdForPruning;
	}
	public void setOldGenRequestCountThresholdForPruning_changeListener(IntegerChangeListener val) {
		oldGenRequestCountThresholdForPruning_changeListener = val;
	}
	public IntegerChangeListener getOldGenRequestCountThresholdForPruning_changeListener() {
		return oldGenRequestCountThresholdForPruning_changeListener;
	}
	public void setOldGenRequestCountThresholdForPruning(Integer val) {
		if (val != null) {
			this.oldGenRequestCountThresholdForPruning = val;
			if (this.getOldGenRequestCountThresholdForPruning_changeListener()!=null)
				this.getOldGenRequestCountThresholdForPruning_changeListener().newValue(val);
			this.logAlways("oldGenRequestCountThresholdForPruning set to [" + this.oldGenRequestCountThresholdForPruning + "]");
		}
	}
	public int getOldGenMinExpirationMs() {
		return oldGenMinExpirationMs;
	}
	public void setOldGenMinExpirationMs(Integer val) {
		if (val != null) {
			this.oldGenMinExpirationMs = val;
			this.logAlways("oldGenMinExpiration set to [" + this.oldGenMinExpirationMs + "]");
		}
	}
	public OldGenerationData createData() {
		
		long expirationForOldGenBytes = System.currentTimeMillis()+
				ThreadLocalRandom.current().nextInt( getOldGenMinExpirationMs(), getOldGenMaxExpirationMs() );

		int oldGenBytesToCreate = ThreadLocalRandom.current().nextInt( getOldGenMaxBytes() );

		OldGenerationData data = new OldGenerationData( expirationForOldGenBytes, oldGenBytesToCreate );
		
		return data;
	}
}
