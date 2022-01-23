package org.byron4j.framework.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode<T> {
    private TreeNode<T> parentNode;
    private Long id;
}
