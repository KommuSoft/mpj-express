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
 * File         : Op.java
 * Author       : Aamir Shafi, Bryan Carpenter
 * Created      : Fri Sep 10 12:22:15 BST 2004
 * Revision     : $Revision: 1.9 $
 * Updated      : $Date: 2005/08/01 22:31:40 $
 */

package mpi;

public class Op {
  OpWorker worker = null;
  User_function funct = null; 

  Op() {
  }

  /* this method should be something like abstract ...
     but its not possible coz these methods like free() and finalize and
     and constructor to create User_fuctions ..is needed here ..
   */
  void perform(Object buf1, int offset, int count) throws MPIException {
  }

  void createInitialBuffer(Object buf, int offset, int count) 
	  throws MPIException{
  }

  void getResultant(Object buf, int offset, int count) throws MPIException {
  }

  public void free() throws MPIException {
  }

  public void finalize() throws MPIException {
  }

  /**
   * Bind a user-defined global reduction operation to an <tt>Op</tt> object.
   * <p>
   * <table>
   * <tr><td><tt> function </tt></td><td> user defined function </tr>
   * <tr><td><tt> commute  </tt></td><td> <tt>true</tt> if commutative,
   *                                      <tt>false</tt> otherwise </tr>
   * </table>
   * <p>
   * Java binding of the MPI operation <tt>MPI_OP_CREATE</tt>.
   */
  public Op(User_function function, boolean commute) throws MPIException {
    funct = function; 
  }

  void getWorker() throws MPIException {
  }

}
