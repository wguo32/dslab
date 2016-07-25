/*
 * Copyright 2014 Attila Szegedi, Daniel Dekany, Jonathan Revusky
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package freemarker.template.utility;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * The equivalent of JDK 1.3 UndeclaredThrowableException.
 */
public class UndeclaredThrowableException extends RuntimeException
{
    
    public UndeclaredThrowableException(Throwable t)
    {
        super(t);
    }
    
    public void printStackTrace()
    {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream ps)
    {
        synchronized (ps)
        {
            ps.print("Undeclared throwable:");
            getCause().printStackTrace(ps);
        }
    }

    public void printStackTrace(PrintWriter pw)
    {
        synchronized (pw)
        {
            pw.print("Undeclared throwable:");
            getCause().printStackTrace(pw);
        }
    }
    
    public Throwable getUndeclaredThrowable() {
        return getCause();
    }
    
}