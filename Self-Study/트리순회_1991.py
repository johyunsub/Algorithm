class Node:
    def __init__(self, item, left, right):
        self.item = item
        self.left, self.right = left, right


def preorder(node):
    ans.append(node.item)
    if node.left != '.':
        preorder(tree[node.left])
    if node.right != '.':
        preorder(tree[node.right])


def inorder(node):
    if node.left != '.':
        inorder(tree[node.left])
    ans.append(node.item)
    if node.right != '.':
        inorder(tree[node.right])


def postorder(node):
    if node.left != '.':
        postorder(tree[node.left])
    if node.right != '.':
        postorder(tree[node.right])
    ans.append(node.item)


N = int(input())
tree = dict()
for i in range(N):
    node, left, right = map(str, input().split())
    tree[node] = Node(item=node, left=left, right=right)

ans = []
preorder(tree['A'])
ans.append('\n')
inorder(tree['A'])
ans.append('\n')
postorder(tree['A'])

print(''.join(ans))
