/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2002 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Commons", "Jexl" and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */

package org.apache.commons.jexl;

import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ASTReference;

import java.io.StringReader;

/**
 *  Implelmentation of an Expression.  Created by the ExpressionFactory.
 *
 *  The expression is different than a script - it's really just either
 *  a reference or expression that we can get the value of.
 *
 *  @author <a href="mailto:geirm@apache.org">Geir Magnusson Jr.</a>
 *  @version $Id: ExpressionImpl.java,v 1.1 2002/04/26 04:23:14 geirm Exp $
 */
class ExpressionImpl implements Expression
{
    /**
     *  Original expression - this is just a 'snippet', not a valid
     *  statement (i.e.  foo.bar() vs foo.bar();
     */
    protected String expression;

    /**
     *  The resulting AST we can call value() on
     */
    protected SimpleNode node;

    /**
     *  do not let this be generally instantiated with a 'new'
     */
    ExpressionImpl(String expr, SimpleNode ref)
    {
        expression = expr;
        node = ref;
    }

    /**
     *  evaluate the expression and return the value
     *
     *  @param context Context containing objects/data used for evaluation
     *  @return value of expression
     */
    public Object evaluate(JexlContext context)
        throws Exception
    {
        return node.value(context);
    }

    /**
     *  returns original expression string
     */
    public String getExpression()
    {
        return expression;
    }
}
