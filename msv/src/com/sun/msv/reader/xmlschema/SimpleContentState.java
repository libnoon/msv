/*
 * @(#)$Id$
 *
 * Copyright 2001 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */
package com.sun.tranquilo.reader.xmlschema;

import com.sun.tranquilo.grammar.Expression;
import com.sun.tranquilo.grammar.xmlschema.ComplexTypeExp;
import com.sun.tranquilo.reader.State;
import com.sun.tranquilo.reader.ExpressionWithChildState;
import com.sun.tranquilo.util.StartTagInfo;

/**
 * used to parse &lt;simpleContent&gt; element.
 * 
 * @author <a href="mailto:kohsuke.kawaguchi@eng.sun.com">Kohsuke KAWAGUCHI</a>
 */
public class SimpleContentState extends ExpressionWithChildState {
	
	protected State createChildState( StartTagInfo tag ) {
		final XMLSchemaReader reader = (XMLSchemaReader)this.reader;
		
		if( super.exp!=null )
			// we have already parsed restriction/extension.
			return null;
		
		if( tag.localName.equals("restriction") )	return reader.sfactory.simpleRst(this,tag);
		if( tag.localName.equals("extension") )		return reader.sfactory.simpleExt(this,tag);
		
		return super.createChildState(tag);
	}

	protected Expression castExpression( Expression halfCastedExpression, Expression newChildExpression ) {
		if( halfCastedExpression!=null )
			// assertion failed.
			// this situation should be prevented by createChildState method.
			throw new Error();
		
		return newChildExpression;
	}
}
