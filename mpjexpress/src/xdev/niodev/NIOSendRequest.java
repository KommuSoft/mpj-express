/*
 The MIT License

 Copyright (c) 2005 - 2007
   1. Distributed Systems Group, University of Portsmouth (2005)
   2. Aamir Shafi (2005 - 2007)
   3. Bryan Carpenter (2005 - 2007)
   4. Mark Baker (2005 - 2007)

 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
 the following conditions:

 The above copyright notice and this permission notice shall be included
 in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
 THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
/*
 * File         : NIOSendRequest.java
 * Author       : Aamir Shafi, Bryan Carpenter
 * Created      : Thu Apr  9 12:22:15 BST 2004
 * Revision     : $Revision: 1.8 $
 * Updated      : $Date: 2005/12/21 13:18:18 $
 *    
 */

package xdev.niodev;

import java.util.UUID;
import java.nio.*;
import mpjdev.Status;
import mpjbuf.NIOBuffer ;
import xdev.*;

public class NIOSendRequest
    extends NIORequest {

  int bytesWritten = 0;
  int bufoffset = 0;

  NIOSendRequest(int tag, ProcessID srcID,ProcessID dstID, mpjbuf.Buffer buf, 
                 int context, int commMode, int sendCounter ) 
	                                      throws XDevException {

    try { 		 
      buf.commit() ;    		 
      this.type = buf.getSectionHeader ();
      this.numEls = buf.getSectionSize ();
    }
    catch(Exception e) {
      throw new XDevException(e);  	    
    }
      
    this.tag = tag;
    this.buffer = buf ; 
    this.srcUUID = srcID.uuid();
    this.dstUUID = dstID.uuid() ;
    this.sBufSize = buf.getSize() ; 
    this.staticBuffer = ((NIOBuffer) buf.getStaticBuffer()).getBuffer() ;
    this.context = context;
    this.commMode = commMode;
    this.sendCounter = sendCounter ;
    //this.rank_source = dstID.rank() ; //shouldn't this be srcID.rank()? 
    this.bufoffset = buf.offset(); 

    if(buf.getDynamicBuffer() != null && buf.getDynamicBuffer().length > 0) {
      this.dynamicBuffer = buf.getDynamicBuffer() ;
      this.dBufSize = buf.getDynamicBuffer().length ;
    }
    
  }

  public Status iwait() {
    if(alreadyCompleted) { 
      return new Status(rank_source, tag, -1) ; 	    
    }
    synchronized (this) {
      if (!this.isCompleted()) {
        this.waitMe();
      }
    }

    Status status = new Status(rank_source, tag, -1);
    complete(status);
    this.alreadyCompleted = true ; 
    return status;
  }

}
