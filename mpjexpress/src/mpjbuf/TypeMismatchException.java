/*
 The MIT License

 Copyright (c) 2005 
   1. Distributed Systems Group, University of Portsmouth
   2. Community Grids Laboratory, Indiana University 

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
 * File         : TypeMismatchException.java
 * Author       : Sang Lim
 * Created      : Mon Feb 04 22:07:42 BST 2001
 * Revision     : $Revision: 1.5 $
 * Updated      : $Date: 2005/07/29 14:03:10 $
 */

package mpjbuf;

public class TypeMismatchException
    extends BufferException {

  public TypeMismatchException() {
    super();
  }

  public TypeMismatchException(String s) {

    super(s);
  }
}
