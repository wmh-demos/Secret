package me.wayne.ds;

import java.util.List;

class MultiTreeNode {

    private String value;
    private List<MultiTreeNode> children;

    public MultiTreeNode(String value, List<MultiTreeNode> children) {
        this.value = value;
        this.children = children;
    }

    public MultiTreeNode() {
    }

    public String value() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addChild(MultiTreeNode node) {
        if (node == null) {
            return;
        }
        this.children.add(node);
    }

    public List<MultiTreeNode> getChildren() {
        return this.children;
    }
}
