/*******************************************************************************
 * Copyright (c) 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.persistence.jpa.jpql.parser;

/**
 * @version 2.4
 * @since 2.4
 * @author Pascal Filion
 */
@SuppressWarnings("nls")
public final class SelectClauseInternalBNF extends JPQLQueryBNF {

	/**
	 * The unique identifier of this BNF rule.
	 */
	public static final String ID = "select_clause_select_expression";

	/**
	 * Creates a new <code>SelectClauseInternalBNF</code>.
	 */
	public SelectClauseInternalBNF() {
		super(ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initialize() {
		super.initialize();

		// Technically, this BNF does not support collection but it's parent
		// select_clause does. But this BNF is used by SelectClause directly
		// to parse the query so the flag has to be turned on here
		setHandleCollection(true);

		setFallbackBNFId(SelectExpressionBNF.ID);
		registerChild(SelectExpressionBNF.ID);
	}
}