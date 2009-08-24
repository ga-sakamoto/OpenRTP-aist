//
// Generated by JTB 1.3.2
//

package jp.go.aist.rtm.rtcbuilder.corba.idl.parser.syntaxtree;

/**
 * Grammar production:
 * nodeList -> ( case_label() )+
 * element_spec -> element_spec()
 * nodeToken -> ";"
 */
public class casex implements Node {
   private Node parent;
   public NodeList nodeList;
   public element_spec element_spec;
   public NodeToken nodeToken;

   public casex(NodeList n0, element_spec n1, NodeToken n2) {
      nodeList = n0;
      if ( nodeList != null ) nodeList.setParent(this);
      element_spec = n1;
      if ( element_spec != null ) element_spec.setParent(this);
      nodeToken = n2;
      if ( nodeToken != null ) nodeToken.setParent(this);
   }

   public casex(NodeList n0, element_spec n1) {
      nodeList = n0;
      if ( nodeList != null ) nodeList.setParent(this);
      element_spec = n1;
      if ( element_spec != null ) element_spec.setParent(this);
      nodeToken = new NodeToken(";");
      if ( nodeToken != null ) nodeToken.setParent(this);
   }

   public void accept(jp.go.aist.rtm.rtcbuilder.corba.idl.parser.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(jp.go.aist.rtm.rtcbuilder.corba.idl.parser.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(jp.go.aist.rtm.rtcbuilder.corba.idl.parser.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(jp.go.aist.rtm.rtcbuilder.corba.idl.parser.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
   public void setParent(Node n) { parent = n; }
   public Node getParent()       { return parent; }
}

