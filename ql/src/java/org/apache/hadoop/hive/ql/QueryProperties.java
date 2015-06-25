/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql;

/**
 *
 * QueryProperties.
 *
 * A structure to contain features of a query that are determined
 * during parsing and may be useful for categorizing a query type
 *
 * These inlucde whether the query contains:
 * a join clause, a group by clause, an order by clause, a sort by
 * clause, a group by clause following a join clause, and whether
 * the query uses a script for mapping/reducing
 */
public class QueryProperties {

  boolean hasJoin = false;
  boolean hasGroupBy = false;
  boolean hasOrderBy = false;
  boolean hasSortBy = false;
  boolean hasJoinFollowedByGroupBy = false;
  boolean hasPTF = false;
  boolean hasWindowing = false;

  // does the query have a using clause
  boolean usesScript = false;

  boolean hasDistributeBy = false;
  boolean hasClusterBy = false;
  boolean mapJoinRemoved = false;
  boolean hasMapGroupBy = false;

  private int noOfJoins = 0;
  private int noOfOuterJoins = 0;
  private boolean hasLateralViews;
  
  private boolean multiDestQuery;
  private boolean filterWithSubQuery;
  
  public boolean hasJoin() {
    return (noOfJoins > 0);
  }

  public void incrementJoinCount(boolean outerJoin) {
    noOfJoins++;
    if (outerJoin)
      noOfOuterJoins++;
  }

  public int getJoinCount() {
    return noOfJoins;
  }

  public int getOuterJoinCount() {
    return noOfOuterJoins;
  }

  public void setHasLateralViews(boolean hasLateralViews) {
    this.hasLateralViews = hasLateralViews;
  }

  public boolean hasLateralViews() {
    return hasLateralViews;
  }

  public boolean hasGroupBy() {
    return hasGroupBy;
  }

  public void setHasGroupBy(boolean hasGroupBy) {
    this.hasGroupBy = hasGroupBy;
  }

  public boolean hasOrderBy() {
    return hasOrderBy;
  }

  public void setHasOrderBy(boolean hasOrderBy) {
    this.hasOrderBy = hasOrderBy;
  }

  public boolean hasSortBy() {
    return hasSortBy;
  }

  public void setHasSortBy(boolean hasSortBy) {
    this.hasSortBy = hasSortBy;
  }

  public boolean hasJoinFollowedByGroupBy() {
    return hasJoinFollowedByGroupBy;
  }

  public void setHasJoinFollowedByGroupBy(boolean hasJoinFollowedByGroupBy) {
    this.hasJoinFollowedByGroupBy = hasJoinFollowedByGroupBy;
  }

  public boolean usesScript() {
    return usesScript;
  }

  public void setUsesScript(boolean usesScript) {
    this.usesScript = usesScript;
  }

  public boolean hasDistributeBy() {
    return hasDistributeBy;
  }

  public void setHasDistributeBy(boolean hasDistributeBy) {
    this.hasDistributeBy = hasDistributeBy;
  }

  public boolean hasClusterBy() {
    return hasClusterBy;
  }

  public void setHasClusterBy(boolean hasClusterBy) {
    this.hasClusterBy = hasClusterBy;
  }

  public boolean hasPTF() {
    return hasPTF;
  }

  public void setHasPTF(boolean hasPTF) {
    this.hasPTF = hasPTF;
  }

  public boolean hasWindowing() {
    return hasWindowing;
  }

  public void setHasWindowing(boolean hasWindowing) {
    this.hasWindowing = hasWindowing;
  }

  public boolean isMapJoinRemoved() {
    return mapJoinRemoved;
  }

  public void setMapJoinRemoved(boolean mapJoinRemoved) {
    this.mapJoinRemoved = mapJoinRemoved;
  }

  public boolean isHasMapGroupBy() {
    return hasMapGroupBy;
  }

  public void setHasMapGroupBy(boolean hasMapGroupBy) {
    this.hasMapGroupBy = hasMapGroupBy;
  }

  public boolean hasMultiDestQuery() {
    return this.multiDestQuery;
  }

  public void setMultiDestQuery(boolean multiDestQuery) {
    this.multiDestQuery = multiDestQuery;
  }

  public void setFilterWithSubQuery(boolean filterWithSubQuery) {
    this.filterWithSubQuery = filterWithSubQuery;
  }

  public boolean hasFilterWithSubQuery() {
    return this.filterWithSubQuery;
  }

  public void clear() {
    hasJoin = false;
    hasGroupBy = false;
    hasOrderBy = false;
    hasSortBy = false;
    hasJoinFollowedByGroupBy = false;
    hasPTF = false;
    hasWindowing = false;

    // does the query have a using clause
    usesScript = false;

    hasDistributeBy = false;
    hasClusterBy = false;
    mapJoinRemoved = false;
    hasMapGroupBy = false;

    noOfJoins = 0;
    noOfOuterJoins = 0;
    
    multiDestQuery = false;
    filterWithSubQuery = false;
  }
}
